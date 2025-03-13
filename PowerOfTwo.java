// class PowerOfTwo {
//     public static void main(String[] args) {
//         int n = 15; // Change this value to print powers of 2 up to 2^n
//         System.out.println("Powers of 2 from 2^1 to 2^" + n + ":");

//         for (int i = 1; i <= n; i++) {
//             int power = 1 << i; // Equivalent to 2^i
//             System.out.println("2^" + i + " = " + power);
//         }
//     }
// }

class PowerOfTwo {
    public static void main(String[] args) {
        int n = 15; // Change this value to print powers of 2 up to 2^n
        System.out.println("Powers of 2 from 2^1 to 2^" + n + ":");

        for (int i = 1; i <= n; i++) {
            int power = (int) Math.pow(2, i); // Using Math.pow() for exponentiation
            System.out.println("2^" + i + " = " + power);
        }
    }
}
