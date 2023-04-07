public class ValidatorService {

    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

    private ValidatorService() {
    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login,
                              String password,
                              String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20!");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongLoginException("Длина пароля должна быть меньше 20!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароли должны совпадать!");
        }
        answer(login, true);
        answer(password, false);
    }

    private static void answer(String string, boolean login)
            throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < string.length(); i++) {
            if (!ALLOWED_CHARACTERS.contains(String.valueOf(string.charAt(i)))) {
                if (login) {
                    throw new WrongLoginException("Символ " + string.charAt(i) + " в логине невалидный! ");
                } else {
                    throw new WrongPasswordException("Символ " + string.charAt(i) + " в пароле невалидный! ");
                }
            }
        }
    }
}
