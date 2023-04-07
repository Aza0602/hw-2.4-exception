public class Main {
    public static void main(String[] args) {

        boolean result = ValidatorService.validate("teSt_1234+", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if (result) {
            System.out.println("Логин и пароль корректные");
        }
    }
}