package te.homework.eval;


import java.util.ArrayList;
import java.util.List;

import static te.homework.eval.Evaluate.TokenType.*;

public class Evaluate {

    private TokenType[] operationPriority = {OPERATION_ADD, OPERATION_SUBTRACT,
            OPERATION_MULTIPLY, OPERATION_DIVIDE};

    public double eval(String input) {
        return evalTree(buildTree(tokenize(input)));
    }

    private double evalTree(Node node) {
        switch (node.type) {
            case NUMERIC: {
                return node.value;
            }
            case OPERATION_ADD: {
                return evalTree(node.left) + evalTree(node.right);
            }
            case OPERATION_DIVIDE: {
                return evalTree(node.left) / evalTree(node.right);
            }
            case OPERATION_MULTIPLY: {
                return evalTree(node.left) * evalTree(node.right);
            }
            case OPERATION_SUBTRACT: {
                return evalTree(node.left) - evalTree(node.right);
            }
            default: {
                return Double.NaN;
            }
        }
    }

    private Node buildTree(List<Token> tokens) {
        if (tokens.size() == 1) {
            return new Node(NUMERIC, tokens.get(0).value);
        }

        if (tokens.get(0).type == OPEN_BRACE
                && tokens.get(tokens.size() - 1).type == CLOSE_BRACE) {
            return buildTree(tokens.subList(1, tokens.size()));
        }

        int depthCounter = 0;
        for (TokenType operation : operationPriority) {
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                if (token.type == OPEN_BRACE) {
                    depthCounter += 1;
                } else if (token.type == CLOSE_BRACE) {
                    depthCounter -= 1;
                } else if (token.type == operation && depthCounter == 0) {
                    return new Node(operation, buildTree(tokens.subList(0, i)),
                            buildTree(tokens.subList(i + 1, tokens.size())));
                }
            }
        }

        return new Node(EMPTY, Double.NaN);
    }

    private List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();

        StringBuilder numBuffer = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                numBuffer.append(ch);
                continue;
            }

            if (numBuffer.length() > 0) {
                tokens.add(new Token(TokenType.NUMERIC, Double.parseDouble(numBuffer.toString())));
                numBuffer.delete(0, numBuffer.length());
            }

            switch (ch) {
                case '+': {
                    tokens.add(new Token(TokenType.OPERATION_ADD));
                    break;
                }
                case '-': {
                    tokens.add(new Token(TokenType.OPERATION_SUBTRACT));
                    break;
                }
                case '*': {
                    tokens.add(new Token(TokenType.OPERATION_MULTIPLY));
                    break;
                }
                case '/': {
                    tokens.add(new Token(TokenType.OPERATION_DIVIDE));
                    break;
                }
                case '(': {
                    tokens.add(new Token(OPEN_BRACE));
                    break;
                }
                case ')': {
                    tokens.add(new Token(TokenType.CLOSE_BRACE));
                    break;
                }
            }
        }

        if (numBuffer.length() > 0) {
            tokens.add(new Token(TokenType.NUMERIC, Double.parseDouble(numBuffer.toString())));
        }

        // todo: correctly process negative numbers


        return tokens;
    }

  /*  private enum NodeType {
        OPERATION_ADD, OPERATION_SUBTRACT, OPERATION_MULTIPLY, OPERATION_DIVIDE, NUMERIC
    }*/

    public enum TokenType {
        OPERATION_ADD, OPERATION_SUBTRACT, OPERATION_MULTIPLY, OPERATION_DIVIDE, NUMERIC,
        OPEN_BRACE, CLOSE_BRACE, EMPTY
    }

    private static class Node {
        final TokenType type;
        final double value;
        final Node left;
        final Node right;

        public Node(TokenType type, double value, Node left, Node right) {
            this.type = type;
            this.value = value;
            this.right = right;
            this.left = left;
        }

        public Node(TokenType type, double value) {
            this(type, value, null, null);
        }

        public Node(TokenType type, Node left, Node right) {
            this(type, Double.NaN, left, right);
        }
    }

    private static class Token {
        final TokenType type;
        final double value;

        public Token(TokenType type, double value) {
            this.type = type;
            this.value = value;
        }

        public Token(TokenType type) {
            this.type = type;
            this.value = Double.NaN;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", value=" + value +
                    '}';
        }
    }
}
