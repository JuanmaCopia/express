import os
import sys
import pandas as pd
import csv
import re

subjects = 'experiments/subjects.csv'
subjects_df = pd.read_csv(subjects)


def replace_seed_in_properties_file(seed, properties_file_path):
    # replace the property express.search.random_seed=n with the new seed
    with open(properties_file_path, 'r') as file:
        filedata = file.read()
        filedata = re.sub(r'express\.search\.random_seed\s*=\s*\d+', f'express.search.random_seed={seed}', filedata)
    with open(properties_file_path, 'w') as file:
        file.write(filedata)


def process_log_file(seed, log_file):
    with open(log_file, 'r') as file:
        lines = file.readlines()
        in_traversal = False
        in_structural_check = False
        in_primitive_check = False
        for line in lines:
            str_line = line.strip()
            # Look for values related to object generation
            if str_line.startswith('Positive Objects Collected:'):
                pos = int(str_line.split(':')[1].strip())
            elif str_line.startswith('Negative Initialization Objects Generated:'):
                neg_initialization = int(str_line.split(':')[1].strip())
            elif str_line.startswith('Negative Heap Objects Generated:'):
                neg_heap = int(str_line.split(':')[1].strip())
            elif str_line.startswith('Negative Primitive Objects Generated:'):
                neg_primitive = int(str_line.split(':')[1].strip())
            elif str_line.startswith('express.object.max_mutations_per_instance'):
                max_mut_per_instance = int(str_line.split('=')[1].strip())
            # Look for values related to the algorithm parameters settings
            if str_line.startswith('express.search.sa.initial_temperature'):
                initial_temp = float(str_line.split('=')[1].strip())
            elif str_line.startswith('express.search.sa.cooling_rate'):
                cooling_rate = float(str_line.split('=')[1].strip())
            elif str_line.startswith('express.search.sa.restart_rounds'):
                restart_rounds = int(str_line.split('=')[1].strip())
            # Look for obtained fitness
            if "Traversal Stage" in str_line:
                in_traversal = True
            elif "Structural Property Check Stage" in str_line:
                in_structural_check = True
                in_traversal = False
            elif "Primitive Properties Search Stage" in str_line:
                in_primitive_check = True
                in_structural_check = False
                in_traversal = False
            if str_line.startswith("Fitness:"):
                if in_traversal:
                    traversal_fitness = float(str_line.split(':')[1].strip())
                if in_structural_check:
                    structural_fitness = float(str_line.split(':')[1].strip())
                if in_primitive_check:
                    primitive_fitness = float(str_line.split(':')[1].strip())
            # Look for time
            if str_line.startswith("Elapsed time:"):
                total_time = int(str_line.split(':')[1].strip()[:-1])
            elif str_line.startswith("Elapsed time during compilation:"):
                compilation_time = int(str_line.split(':')[1].strip()[:-1])
            elif str_line.startswith("Elapsed time during fitness function evaluation:"):
                fitness_time = int(str_line.split(':')[1].strip()[:-1])
    return [seed, pos, neg_initialization, neg_heap, neg_primitive, max_mut_per_instance, initial_temp, cooling_rate, restart_rounds, traversal_fitness, structural_fitness, primitive_fitness, total_time, compilation_time, fitness_time]

def analyze_subject_with_seed(seed, target_subject, target_class, target_properties):
    print("analyzing with seed:", seed)
    subject_path = target_class.replace('.', '/')
    subject_path = subject_path[:subject_path.rfind('/')]

    # First update the seed in the properties file
    properties_file_path = subject_path + '/' + target_properties
    print("going to modify properties file:", properties_file_path)
    replace_seed_in_properties_file(seed, properties_file_path)

    # Now run the experiment
    log_file = f'{output_dir}/log-{seed}.txt'
    cmd = f'./gradlew run --args="{properties_file_path}" > {log_file}'
    print("running command:", cmd)
    os.system(cmd)

    # Read the log file to get the results
    return process_log_file(seed, log_file)


def analyze_subject(target_subject, target_class, target_properties):
    """Analyzes a target subject with multiple seeds"""
    print("subject:", target)
    print("class:", target_class)
    print("properties:", target_properties)
    print()

    ten_random_seeds = [99, 42, 27, 13, 7, 54, 68, 33, 75, 88]

    subject_results_summary_csv = f'experiments/results/{target_subject}/effectiveness_summary.csv'
    subject_results_summary_header = ['seed', 'pos_obj', 'neg_initialization_obj', 'neg_heap_obj','neg_primitive_obj', 'max_mut_per_instance', 'initial_temp', 'cooling_rate', 'restart_rounds', 'traversal_fitness', 'structural_fitness', 'primitive_fitness', 'total_time', 'compilation_time', 'fitness_time']
    if os.path.exists(subject_results_summary_csv):
        os.remove(subject_results_summary_csv)
    subject_results_rows = [subject_results_summary_header]
    for seed in ten_random_seeds:
        row_with_results = analyze_subject_with_seed(seed, target_subject, target_class, target_properties)
        subject_results_rows.append(row_with_results)
        break # only one seed for now
    with open(subject_results_summary_csv, 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(subject_results_rows)
    return


# main code
target = sys.argv[1]
target_subject = subjects_df[subjects_df['name'] == target]
target_class = target_subject['class'].values[0]
target_properties = target_subject['properties_file'].values[0]

output_dir = f'experiments/results/{target}'
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

# run the experiment
analyze_subject(target, target_class, target_properties)