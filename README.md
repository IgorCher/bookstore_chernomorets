# **Bookstore**

**Classes:**
* Book;
* BookDaoImpl;
* Main.

**Interface:**
* BookDao
## **module1_dao**

Class **Book** -  has methods: getters, setters, equals, hashCode
and toString.

Class **BookDaoImpl** - implements methods of the **BookDao**
interface:
* ***findAll*** - output a list of all books;
* ***find*** - search a book by its id;
* ***findByIsbn*** - search a book by its ISBN;
* ***create*** - creates a new book in DB;
* ***update*** - updates a book in the DB;
* ***delete*** - delete a book from DB;
* ***findByAuthor*** - search a book by its author;
* ***countAll*** - output size of list of all books.
