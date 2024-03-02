import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnalizadorLexico {

    private static final Map<String, String> TOKENS = new HashMap<>();

    static {
        TOKENS.put("[a-zA-Z][a-zA-Z0-9_]*", "IDENTIFICADOR");
        TOKENS.put("int", "PALABRA_CLAVE");
        TOKENS.put("float", "PALABRA_CLAVE");
        TOKENS.put("if", "PALABRA_CLAVE");
        TOKENS.put("else", "PALABRA_CLAVE");
        TOKENS.put("while", "PALABRA_CLAVE");
        TOKENS.put("=", "OPERADOR");
        TOKENS.put("+", "OPERADOR");
        TOKENS.put("-", "OPERADOR");
        TOKENS.put("*", "OPERADOR");
        TOKENS.put("/", "OPERADOR");
        TOKENS.put(";", "PUNTO_Y_COMA");
        TOKENS.put(",", "COMA");
        TOKENS.put("\\(", "PARENTESIS_IZQUIERDO");
        TOKENS.put("\\)", "PARENTESIS_DERECHO");
        TOKENS.put("\\{", "LLAVE_IZQUIERDA");
        TOKENS.put("\\}", "LLAVE_DERECHA");
        TOKENS.put("\"", "COMILLA_DOBLE");
        TOKENS.put("'", "COMILLA_SIMPLE");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el código fuente:");
        String codigoFuente = scanner.nextLine();

        List<Token> tokens = new ArrayList<>();
        int pos = 0;
        while (pos < codigoFuente.length()) {
            for (Map.Entry<String, String> entry : TOKENS.entrySet()) {
                String regex = entry.getKey();
                String token = entry.getValue();

                if (codigoFuente.substring(pos).matches(regex)) {
                    tokens.add(new Token(token, codigoFuente.substring(pos, pos + regex.length())));
                    pos += regex.length();
                    break;
                }
            }
        }

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
