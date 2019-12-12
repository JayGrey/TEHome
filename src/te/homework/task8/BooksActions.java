package te.homework.task8;

enum BooksActions {
    SHOW_ALL_BOOKS(1), SHOW_BOOKS_BY_TYPE(2), ADD_NEW_BOOK(3), EXIT(0);

    private int id;

    BooksActions(int id) {
        this.id = id;
    }

    static BooksActions getAction(int num) {
        switch (num) {
            case 1: {
                return SHOW_ALL_BOOKS;
            }

            case 2: {
                return SHOW_BOOKS_BY_TYPE;
            }

            case 3: {
                return ADD_NEW_BOOK;
            }

            case 0: {
                return EXIT;
            }

            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getId() {
        return id;
    }
}