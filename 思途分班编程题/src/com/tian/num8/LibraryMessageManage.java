package com.tian.num8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 题目8: 图书馆信息管理 功能要求： 1-进书、办理借书卡 2-借书和还书功能 3-查询某书的借阅记录 4-查询谋卡的借阅记录
 * 5-按借阅次数，显示图书信息。
 * 
 * @author 王伟
 *
 */
public class LibraryMessageManage {

	private static Library library = new Library();

	public static void main(String[] args) throws InterruptedException {
		// 图书总库
		ArrayList<Book> listTotal = new ArrayList<Book>();
		listTotal.add(new Book(1, "西游记"));
		listTotal.add(new Book(2, "水浒传"));
		listTotal.add(new Book(3, "三国演义"));
		listTotal.add(new Book(4, "红楼梦"));
		listTotal.add(new Book(5, "Java程序设计"));
		listTotal.add(new Book(6, "Spring 实战"));
		listTotal.add(new Book(7, "深入理解JVM"));
		listTotal.add(new Book(8, "大话数据结构"));
		listTotal.add(new Book(9, "数据库概论"));
		listTotal.add(new Book(10, "数据分析"));
		listTotal.add(new Book(11, "高等代数"));
		listTotal.add(new Book(12, "操作系统"));
		listTotal.add(new Book(13, "计算机组成原理"));

		String ch;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("==========图书管理系统==========");
			System.out.println();
			System.out.println("1、进书(输入a,请根据总库中的图书进行书)");
			System.out.println("2、办理借书卡(输入b)");
			System.out.println("3、借书(输入c)");
			System.out.println("4、还书(输入d)");
			System.out.println("5、查询某书的借阅记录(e)");
			System.out.println("6、查询某卡的借阅记录(f)");
			System.out.println("7、按查阅次数显示图书信息(g)");
			System.out.println("输入exit退出系统");
			System.out.println("请输入业务选项:");
			ch = scanner.nextLine();
			if (ch.equals("exit")) {
				System.out.println("正在退出...");
				TimeUnit.SECONDS.sleep(3);
				break;
			}
			switch (ch) {
			case "a": {
				System.out.println("供应商的书籍如下：");
				for (Book book : listTotal) {
					System.out.println(book.getBookName());
				}
				System.out.println();
				while (true) {
					System.out.println("请输入进书名称:");
					String bookName = scanner.nextLine();
					System.out.println("请输入进书数量");
					int count = scanner.nextInt();
					scanner.nextLine();
					library.buyBook(listTotal, bookName, count);
					System.out.println("若退出进书请输入a1,继续进书输入任意字符");
					String a1 = scanner.nextLine();
					if (a1.equals("a1")) {
						break;
					}
				}
				break;
			}
			case "b":
				System.out.println("请输入办卡人姓名:");
				String userName = scanner.nextLine();
				library.transactionCard(userName);
				TimeUnit.SECONDS.sleep(3);
				break;
			case "c":
				System.out.println("请输入借阅人姓名:");
				String userName1 = scanner.nextLine();
				System.out.println("请输入想借阅的书:");
				String bookName1 = scanner.nextLine();
				library.borrowBook(userName1, bookName1);
				TimeUnit.SECONDS.sleep(3);
				break;
			case "d":
				System.out.println("请输入还书人姓名:");
				String userName2 = scanner.nextLine();
				System.out.println("请输入所还书籍名称:");
				String bookName2 = scanner.nextLine();
				library.returnBook(userName2, bookName2);
				TimeUnit.SECONDS.sleep(3);
				break;
			case "e":
				System.out.println("请输入要查询的书名:");
				String bookName3 = scanner.nextLine();
				library.searchBook(bookName3);
				TimeUnit.SECONDS.sleep(3);
				break;
			case "f":
				System.out.println("请输入持有卡的姓名:");
				String userName3 = scanner.nextLine();
				library.searchCard(userName3);
				TimeUnit.SECONDS.sleep(3);
				break;
			case "g":
				System.out.println("图书信息为:");
				library.PrintMessageByTime();
				TimeUnit.SECONDS.sleep(3);
				break;
			default:
				break;
			}
		}
		scanner.close();
		System.out.println();
		System.out.println("已退出");

	}

}

//图书馆
class Library {

	// 书名和借阅次数
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	/**
	 * 图书馆仓库
	 */
	private ArrayList<Book> warehouseLibray = new ArrayList<Book>();

	// 某书的借阅信息
	private ArrayList<BookBrow> messageBook = new ArrayList<BookBrow>();
	// 借阅卡仓库
	private ArrayList<LibraryCard> CardTotal = new ArrayList<LibraryCard>();

	/**
	 * 根据书名进书
	 * 
	 * @param list
	 * @param bookName
	 */
	public void buyBook(ArrayList<Book> list, String bookName, int count) {
		if (bookName == null || bookName.equals("")) {
			System.out.println("输入书名为空!");
		}
		if (count == 0) {
			System.out.println("进书数目输入错误!");
		}
		boolean flag = false;
		for (Book book : list) {
			String name = book.getBookName();
			if (name.equals(bookName)) {
				book.setCount(count);
				warehouseLibray.add(book);
				flag = true;
				System.out.println("进书成功!");
			}
		}
		if (!flag) {
			System.out.println("仓库中不存在该书");
		}
	}

	// 办卡
	public void transactionCard(String name) {
		if (name == null || name.equals("")) {
			System.out.println("输入姓名为空!");
		}
		boolean flag = true;
		for (LibraryCard card : CardTotal) {
			if (card.getName().equals(name)) {
				flag = false;
			}
		}
		if (flag) {
			CardTotal.add(new LibraryCard(name));
			System.out.println("办卡成功");
		} else {
			System.out.println("办卡失败！已经存在该用户");
		}

	}

	// 借书功能
	public void borrowBook(String userName, String bookName) {
		if (userName == null || userName.equals("")) {
			System.out.println("输入姓名为空!");
		}
		if (bookName == null || bookName.equals("")) {
			System.out.println("输入书名为空!");
		}
		boolean flag = true;
		boolean flag1 = false;
		boolean flag2 = false;
		for (LibraryCard card : CardTotal) {
			if (card.getName().equals(userName)) {
				flag1 = true;
				Book book1 = null;
				for (Book book : warehouseLibray) {
					if (book != null && book.getBookName().equals(bookName)) {

						messageBook.add(new BookBrow(userName, " 已借 ", bookName));
						flag = true;
						for (Book book2 : card.getAlreadyBorrow()) {
							if (book2 != null && book2.getBookName().equals(bookName)) {
								flag2 = true;
								book2.setCount(book2.getCount() + 1);
								break;
							} else {
								flag2 = false;

							}
						}
						if (!flag2) {
							book1 = new Book(book.getId(), bookName, 1);
							card.getAlreadyBorrow().add(book1);
						}

						book.setCount(book.getCount() - 1);
						if (book.getCount() == 0) {
							warehouseLibray.remove(book);
						}
						boolean flag3 = false;
						for (Entry<String, Integer> entry : map.entrySet()) {
							if (entry.getKey().equals(bookName)) {
								flag3 = true;
								entry.setValue(entry.getValue() + 1);
								break;
							} else {
								flag3 = false;
							}
						}
						if (!flag3) {
							map.put(bookName, 1);
						}

						break;
					} else {
						flag = false;
					}

				}

				break;
			} else {
				flag1 = false;

			}

		}
		if (!flag1) {
			System.out.println("该用户不存在借阅卡!");

		}
		if (!flag) {
			System.out.println("借阅的书不存在!");

		}
		if (flag && flag1) {
			System.out.println("借书成功");
		}

	}

	public Book getBookBywarehouseLibray(String bookName) {
		for (Book book : warehouseLibray) {
			if (book != null && book.getBookName().equals(bookName)) {
				return book;
			}
		}
		return null;
	}

	// 还书功能
	public void returnBook(String userName, String bookName) {
		if (userName == null || userName.equals("")) {
			System.out.println("输入姓名为空!");
		}
		if (bookName == null || bookName.equals("")) {
			System.out.println("输入书名为空!");
		}
		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		for (LibraryCard card : CardTotal) {
			if (card != null && card.getName().equals(userName)) {
				flag2 = true;
				if (card.getAlreadyBorrow().size() != 0) {
					flag1 = true;
					for (int i = card.getAlreadyBorrow().size() - 1; i >= 0; i--) {
						Book book2 = card.getAlreadyBorrow().get(i);
						if (book2 != null && bookName.equals(book2.getBookName())) {
							flag = true;
							int id1 = book2.getId();
							if (book2.getCount() == 1) {
								card.getAlreadyBorrow().remove(i);

								card.getHasAlso().add(book2);
							} else {
								book2.setCount(book2.getCount() - 1);
							}

							Book bookByName = card.getBookByName(bookName);
							if (bookByName != null) {
								bookByName.setCount(bookByName.getCount() + 1);
							} else {
								card.getHasAlso().add(new Book(bookName, 1));
							}

							Book book = getBookBywarehouseLibray(bookName);
							if (book != null) {
								book.setCount(book.getCount() + 1);

							} else {
								warehouseLibray.add(new Book(id1, bookName));
							}
							messageBook.add(new BookBrow(userName, " 已还 ", bookName));
							break;
						} else {
							flag = false;

						}
					}
				} else {
					flag1 = false;

				}
				break;
			} else {
				flag2 = false;

			}

		}
		if (!flag2) {
			System.out.println("该用户没有办理借阅卡!");

		}
		if (!flag) {
			System.out.printf("该用户没有借阅 %s", bookName);
		}
		if (!flag1) {

			System.out.println("该用户还没有借书!");
		}
		if (flag2 && flag && flag1) {
			System.out.println("还书成功");
		}

	}

	// 查询某书的借阅记录
	public void searchBook(String bookName) {
		if (bookName == null || bookName.equals("")) {
			System.out.println("输入的书名为空");
		}
		boolean flag = false;
		for (BookBrow bookBrow : messageBook) {
			if (bookBrow != null && bookBrow.getBook().equals(bookName)) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		if (!flag) {
			System.out.println("该书还没有借阅记录!");
		} else {
			for (BookBrow bookBrow : messageBook) {
				if (bookBrow.getBook().equals(bookName)) {
					System.out.println(bookBrow.getName() + bookBrow.getMiddle() + bookBrow.getBook());
				}
			}
		}
	}

	// 查询某卡的借阅记录
	public void searchCard(String userName) {
		if (userName == null || userName.equals("")) {
			System.out.println("输入姓名为空!");
		}
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		for (LibraryCard card : CardTotal) {
			if (card != null && card.getName().equals(userName)) {
				flag = true;
				ArrayList<Book> alreadyBorrow = card.getAlreadyBorrow();
				ArrayList<Book> hasAlso = card.getHasAlso();

				for (Book book : alreadyBorrow) {
					if (book == null) {

						break;
					} else {
						flag1 = true;
						System.out.println(book.getBookName() + " 已借" + " 数目:" + book.getCount());

					}

				}
				System.out.println();

				for (Book book : hasAlso) {
					if (book == null) {
						break;
					} else {
						flag2 = true;
						System.out.println(book.getBookName() + " 已还" + " 数目:" + book.getCount());
					}

				}
				break;
			} else {
				flag = false;
			}
		}
		if (!flag) {
			System.out.println("该用户不存在!");
		}
		if (!flag1) {
			System.out.println("还没有借阅过书");
		}
		if (!flag2) {
			System.out.println("还没有还过书");
		}
	}

	// 按借阅次数，显示图书信息。
	public void PrintMessageByTime() {
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, (o1, o2) -> {
			return Integer.compare(o2.getValue(), o1.getValue());
		});
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}

//存储书的借阅记录
class BookBrow {
	private String name;
	private String middle;

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public BookBrow(String name, String middle, String book) {
		super();
		this.name = name;
		this.middle = middle;
		this.book = book;
	}

	private String book;

	public BookBrow(String name, String book) {
		super();
		this.name = name;
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

}

/*
 * 借阅卡
 */
class LibraryCard {
	// 持卡人姓名
	private String name;
	private static int id;
	// 已经借阅书籍
	private ArrayList<Book> alreadyBorrow = new ArrayList<Book>();
	// 已经借阅并且已还的书籍
	private ArrayList<Book> hasAlso = new ArrayList<Book>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		LibraryCard.id = id;
	}

	public LibraryCard(String name) {
		super();
		this.name = name;
		id++;
	}

	public ArrayList<Book> getAlreadyBorrow() {
		return alreadyBorrow;
	}

	public ArrayList<Book> getHasAlso() {
		return hasAlso;
	}

	public Book getBookByName(String bookName) {
		for (Book book : hasAlso) {
			String name = book.getBookName();
			if (name.equals(bookName)) {
				return book;
			}
		}
		return null;
	}
}

//书籍信息
class Book {
	private int id;
	/**
	 * 书名
	 */
	private String bookName;
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Book(int id, String bookName, int count) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.count = count;
		id++;
	}

	public Book(int id, String bookName) {
		super();
		this.id = id;
		this.bookName = bookName;
	}

	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}

	public Book(String bookName, int count) {
		super();
		this.bookName = bookName;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", count=" + count + "]";
	}

}
