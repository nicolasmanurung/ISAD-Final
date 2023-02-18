import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> consonantChar = new HashMap<>();
        HashMap<Character, Integer> vowelChar = new HashMap<>();

        setVowelChar(vowelChar);
        setConsonantChar(consonantChar);

        boolean isUserFinishTheAnswers = false;

        while (!isUserFinishTheAnswers) {
            Scanner userTextInput = new Scanner(System.in);
            String userInput = userTextInput.nextLine();

            if (validateLengthNumberInput(userInput)) {
                System.out.println("\nVokal yang digunakan: ");
                System.out.print(getCharactersThatUsed(vowelChar, userInput.toLowerCase()));

                System.out.println("\nVokal yang tidak digunakan: ");
                System.out.println(getKeysByValue(vowelChar, 0));

                System.out.println("\nKonsonan yang digunakan: ");
                System.out.print(getCharactersThatUsed(consonantChar, userInput.toLowerCase()));

                System.out.println("\nKonsonan yang tidak digunakan: ");
                System.out.print(getKeysByValue(consonantChar, 0));

                isUserFinishTheAnswers = true;
            } else {
                System.out.println("Input Karakter minimal 10 dan maksimal 300");
            }
        }
    }

    private static void setVowelChar(HashMap<Character, Integer> vowelChar) {
        vowelChar.put('a' , 0);
        vowelChar.put('i' , 0);
        vowelChar.put('u' , 0);
        vowelChar.put('e' , 0);
        vowelChar.put('o' , 0);
    }

    private static void setConsonantChar(HashMap<Character, Integer> consonantChar) {
        consonantChar.put('b' , 0);
        consonantChar.put('c' , 0);
        consonantChar.put('d' , 0);
        consonantChar.put('f' , 0);
        consonantChar.put('g' , 0);
        consonantChar.put('h' , 0);
        consonantChar.put('j' , 0);
        consonantChar.put('k' , 0);
        consonantChar.put('l' , 0);
        consonantChar.put('m' , 0);
        consonantChar.put('n' , 0);
        consonantChar.put('p' , 0);
        consonantChar.put('q' , 0);
        consonantChar.put('r' , 0);
        consonantChar.put('s' , 0);
        consonantChar.put('t' , 0);
        consonantChar.put('v' , 0);
        consonantChar.put('w' , 0);
        consonantChar.put('x' , 0);
        consonantChar.put('y' , 0);
        consonantChar.put('z' , 0);
    }

    private static boolean validateLengthNumberInput(String input) {
        return input.length() >= 10 && input.length() <= 300;
    }

    private static Set<Character> getCharactersThatUsed(HashMap<Character, Integer> characters, String inputText) {
        Set<Character> charactersThatUsed = new HashSet<>();

        for (int i = 0; i < inputText.length(); i++) {
            if (characters.containsKey(inputText.charAt(i))) {
                characters.put(inputText.charAt(i), 1);
                charactersThatUsed.add(inputText.charAt(i));
            }
        }
        return charactersThatUsed;
    }

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}