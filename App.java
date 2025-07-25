public class App {
    public static void main(String[] args) {
        ArrayIntList newList = new ArrayIntList(100);

        newList.add(0);
        newList.add(15);
        newList.add(22);

        ArrayIntList newerList = newList.runningTotal();

        System.out.println(newerList.toString());
        
    }


}
