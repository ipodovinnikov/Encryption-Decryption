class Problem {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("mode") && i % 2 == 0) {
                System.out.println(args[i + 1]);
                counter++;
            }
        }
        if (counter == 0) System.out.println("default");
    }
}