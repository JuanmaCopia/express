package express.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LinkedIdentityHashSet<E> extends AbstractSet<E> {
    Set<IdentityWrapper> set;

    static class IdentityWrapper {
        Object obj;

        IdentityWrapper(Object obj) {
            this.obj = obj;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof IdentityWrapper iw))
                return false;
            return this.obj == iw.obj;
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(obj);
        }
    }

    public LinkedIdentityHashSet() {
        this.set = new LinkedHashSet<>();
    }

    public LinkedIdentityHashSet(List<E> elements) {
        this.set = new LinkedHashSet<>();
        for (E elem : elements) {
            add(elem);
        }
    }

    @Override
    public boolean add(E e) {
        return set.add(new IdentityWrapper(e));
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final Iterator<IdentityWrapper> it = set.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public E next() {
                IdentityWrapper wrapper = it.next();
                return (E) wrapper.obj;
            }

            @Override
            public void remove() {
                it.remove();
            }
        };
    }

    @Override
    public int size() {
        return set.size();
    }
}
