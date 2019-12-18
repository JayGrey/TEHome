package te.homework.eval;


import java.util.*;

import static te.homework.eval.Evaluate.TokenType.*;

public class Evaluate {

    // from least to most
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

    private boolean checkTopMostBraces(List<Token> tokens) {
        if (tokens.get(0).type == OPEN_BRACE) {
            int depth = 0;
            int openBracePos = -1;
            int closeBracePos = -1;
            int i;
            for (i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                if (token.type == OPEN_BRACE) {
                    if (depth == 0) {
                        openBracePos = i;
                    }
                    depth += 1;
                } else if (token.type == CLOSE_BRACE) {
                    depth -= 1;
                    if (depth == 0) {
                        closeBracePos = i;
                    }
                    if (openBracePos == 0 && closeBracePos == tokens.size() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Node buildTree(List<Token> tokens) {
        if (tokens.size() == 1) {
            return new Node(NUMERIC, tokens.get(0).value);
        }

        if (checkTopMostBraces(tokens)) {
            return buildTree(tokens.subList(1, tokens.size() - 1));
        }

        for (TokenType operation : operationPriority) {
            int depth = 0;
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                if (token.type == OPEN_BRACE) {
                    depth += 1;
                } else if (token.type == CLOSE_BRACE) {
                    depth -= 1;
                } else if (token.type == operation && depth == 0) {
                    return new Node(operation, buildTree(tokens.subList(0, i)),
                            buildTree(tokens.subList(i + 1, tokens.size())));
                }
            }
        }

        return new Node(EMPTY, Double.NaN);
    }


    private List<Token> tokenize(String input) {
        List<Token> result = new ArrayList<>();

        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isSpaceChar(c)) {
                deque.addFirst(c);
            }
        }

        expression(result, deque);

        return result;
    }

    private void subExpression(List<Token> tokens, Deque<Character> deque) {
        char ch = !deque.isEmpty() ? deque.peekLast() : 0;
        if (ch == '(') {
            deque.removeLast();
            tokens.add(Token.OPEN_BRACE);
            expression(tokens, deque);
            ch = !deque.isEmpty() ? deque.peekLast() : 0;
            if (ch == ')') {
                deque.removeLast();
                tokens.add(Token.CLOSE_BRACE);
            }
        }
    }

    private void expression(List<Token> tokens, Deque<Character> deque) {
        char ch = !deque.isEmpty() ? deque.peekLast() : 0;

        // subexpression
        if (ch == '(') {
            subExpression(tokens, deque);
        } else {
            getNumber(deque).ifPresent(tokens::add);
        }


        while (!deque.isEmpty() && deque.peekLast() != ')') {
            getOperation(deque).ifPresent(tokens::add);

            ch = !deque.isEmpty() ? deque.peekLast() : 0;
            if (ch == '(') {
                subExpression(tokens, deque);
            } else {
                getNumber(deque).ifPresent(tokens::add);
            }

        }
    }

    private Optional<Token> getOperation(Deque<Character> deque) {
        char ch = !deque.isEmpty() ? deque.removeLast() : 0;
        switch (ch) {
            case '+': {
                return Optional.of(Token.ADD);
            }
            case '-': {
                return Optional.of(Token.SUBTRACT);
            }
            case '/': {
                return Optional.of(Token.DIVIDE);
            }
            case '*': {
                return Optional.of(Token.MULTIPLY);
            }
            default: {
                return Optional.empty();
            }
        }
    }

    private Optional<Token> getNumber(Deque<Character> deque) {
        StringBuilder buffer = new StringBuilder();

        // 1
        char ch = !deque.isEmpty() ? deque.peekLast() : 0;
        if (ch == '+' || ch == '-') {
            buffer.append(deque.pollLast());
        }

        ch = !deque.isEmpty() ? deque.peekLast() : 0;
        if (Character.isDigit(ch)) {
            while (!deque.isEmpty() && Character.isDigit(deque.peekLast())) {
                buffer.append(deque.pollLast());
            }

            ch = !deque.isEmpty() ? deque.peekLast() : 0;
            if (ch == '.') {
                buffer.append(deque.pollLast());
            }

            while (!deque.isEmpty() && Character.isDigit(deque.peekLast())) {
                buffer.append(deque.pollLast());
            }

        } else if (ch == '.') {
            buffer.append(deque.pollLast());

            ch = !deque.isEmpty() ? deque.peekLast() : 0;
            if (Character.isDigit(ch)) {
                while (!deque.isEmpty() && Character.isDigit(deque.peekLast())) {
                    buffer.append(deque.pollLast());
                }
            } else {
                return Optional.empty();
            }

        } else {
            return Optional.empty();
        }

        return Optional.of(new Token(NUMERIC, Double.parseDouble(buffer.toString())));
    }

    enum TokenType {
        OPERATION_ADD, OPERATION_SUBTRACT, OPERATION_MULTIPLY, OPERATION_DIVIDE, NUMERIC,
        OPEN_BRACE, CLOSE_BRACE, EMPTY
    }

    private static class Node {
        final TokenType type;
        final double value;
        final Node left;
        final Node right;

        Node(TokenType type, double value, Node left, Node right) {
            this.type = type;
            this.value = value;
            this.right = right;
            this.left = left;
        }

        Node(TokenType type, double value) {
            this(type, value, null, null);
        }

        Node(TokenType type, Node left, Node right) {
            this(type, Double.NaN, left, right);
        }
    }

    private static class Token {
        private final static Token ADD = new Token(OPERATION_ADD);
        private final static Token DIVIDE = new Token(OPERATION_DIVIDE);
        private final static Token MULTIPLY = new Token(OPERATION_MULTIPLY);
        private final static Token SUBTRACT = new Token(OPERATION_SUBTRACT);
        private final static Token OPEN_BRACE = new Token(TokenType.OPEN_BRACE);
        private final static Token CLOSE_BRACE = new Token(TokenType.CLOSE_BRACE);
        final TokenType type;
        final double value;

        Token(TokenType type, double value) {
            this.type = type;
            this.value = value;
        }

        Token(TokenType type) {
            this.type = type;
            this.value = Double.NaN;
        }

        @Override
        public String toString() {
            switch (type) {
                case OPERATION_SUBTRACT: {
                    return "T-";
                }
                case OPERATION_MULTIPLY: {
                    return "T*";
                }
                case OPERATION_DIVIDE: {
                    return "T/";
                }
                case OPERATION_ADD: {
                    return "T+";
                }
                case OPEN_BRACE: {
                    return "T(";
                }
                case CLOSE_BRACE: {
                    return "T)";
                }
                case NUMERIC: {
                    return String.format("T(%f)", value);
                }
                case EMPTY: {
                    return "T(E)";
                }
            }
            return "Token{" +
                    "type=" + type +
                    ", value=" + value +
                    '}';
        }
    }
}
