public class ArrayIntList {
    public static final int DEFAULT_CAPACITY = 100;
    private int[] elements;
    private int size;

    public ArrayIntList() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayIntList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity must not be negative");
        this.elements = new int[capacity];
        this.size = 0;
    }

    public void add(int value) {
        this.elements[this.size] = value;
        this.size++;
    }

    // add element to specific index of the list
    public void add(int index, int value) {
        // shift all elements from the
        // given index to the right by one
        for (int i = this.size; i >= index + 1; i--)
            this.elements[i] = this.elements[i - 1];
        // overwrite the value to the given index
        this.elements[index] = value;
        this.size++;
    }

    @Override // this method overwrite from Object
    public String toString() {
        // base case when list is empty
        if (this.size == 0)
            return "[]";
        // use the fencepost technique
        String result = "[" + this.elements[0];
        for (int i = 1; i < this.size; i++)
            result += ", " + this.elements[i];
        result += "]";
        return result;
    }

    public int size() {
        return this.size;
    }

    // this method get the value at given index
    public int get(int index) {
        return this.elements[index];
    }

    // this method set the new value at given index
    public int set(int index, int value) {
        return this.elements[index] = value;
    }

    public void remove(int index) {
        for (int i = index; i < this.size; i++)
            this.elements[i] = this.elements[i + 1];
        this.size--;
    }

    // this method find index of given value in list
    public int indexOf(int value) {
        for (int i = 0; i < this.size; i++)
            if (this.elements[i] == value)
                return i;
        return -1; // not found the item in the list
    }

    // this method clear the list
    public void clear() {
        this.size = 0;
    }

    public ArrayIntList runningTotal() {
        ArrayIntList result = new ArrayIntList(this.elements.length);

        if (this.size > 0) {
            result.add(this.elements[0]); // first element is the same
            for (int i = 1; i < this.size; i++) {
                result.add(result.get(i - 1) + this.elements[i]);
            }
        }

        return result;
    }

    public void removeAll(int value) {
        int i = 0;
        while (i < this.size) {
            if (this.elements[i] == value) {
                this.remove(i);
                // Don't increment i since we removed an element
            } else {
                i++;
            }
        }

    }

    public void mirror() {
        // Ensure capacity is sufficient for the mirrored elements
        ensureCapacity();

        // Append elements in reverse order
        for (int i = this.size - 1; i >= 0; i--) {
            this.add(this.elements[i]);
        }
    }

    public void ensureCapacity() {
        this.size = this.size * 2;
    }
}
