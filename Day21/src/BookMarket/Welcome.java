package BookMarket;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.market.bookitem.Book;
import com.market.cart.Cart;
import com.market.member.Admin;
import com.market.member.User;
import com.market.exception.CartException;
import java.util.ArrayList;

public class Welcome {
	static final int NUM_BOOK = 3;
	static final int NUM_ITEM = 7;
	// static CartItem[] mCartItem = new CartItem[NUM_BOOK];
	// static int mCartCount = 0;
	static Cart mCart = new Cart();
	static User mUser;

	public static void main(String[] args) {
		// String[][] mBook = new String[NUM_BOOK][NUM_ITEM];
		// Book[] mBookList = new Book[NUM_BOOK];
		// Book[] mBookList;
		ArrayList<Book> mBookList;
		int mTotalBook = 0;

		Scanner input = new Scanner(System.in);
		System.out.print("����� �̸��� �Է��ϼ��� : ");
		String userName = input.next();

		System.out.print("����ó�� �Է��ϼ��� : ");
		int userMobile = input.nextInt();
		// System.out.println("Welcome to Shopping Mall"); ----[������Ʈ 1-1]���� �ۼ��� ����
		// System.out.println("Welcome to Book Market!"); ----[������Ʈ 1-1]���� �ۼ��� ����

		mUser = new User(userName, userMobile);

		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to Book Market!";

		boolean quit = false;

		while (!quit) {
			System.out.println("***********************************************");
			System.out.println("\t" + greeting);
			System.out.println("\t" + tagline);
			/*
			 * System.out.println("***********************************************");
			 * System.out.println(" 1. �� ���� Ȯ���ϱ� \t4. �ٱ��Ͽ� �׸� �߰��ϱ�");
			 * System.out.println(" 2. ��ٱ��� ��ǰ ��� ���� \t5. ��ٱ��Ͽ� �׸���� ���̱�");
			 * System.out.println(" 3. ��ٱ��� ���� \t6. ��ٱ����� �׸� �����ϱ�");
			 * System.out.println(" 7. ������ ǥ���ϱ� \t8. ����");
			 * System.out.println("***********************************************");
			 */

			menuIntroduction();

			try {
				System.out.print("�޴� ��ȣ�� �������ּ��� ");
				int n = input.nextInt();
				// System.out.println(n + "���� �����߽��ϴ�");

				if (n < 1 || n > 9) {
					System.out.println("1���� 9������ ���ڸ� �Է��ϼ���.");
				} else {
					switch (n) {

					case 1:
						// System.out.println("���� �� ���� : ");
						// System.out.println("�̸� " + userName + " ����ó " + userMobile);
						menuGuestInfo(userName, userMobile);
						break;
					case 2:
						// System.out.println("��ٱ��� ��ǰ ��� ���� :");
						menuCartItemList();
						break;
					case 3:
						// System.out.println("��ٱ��� ����");
						menuCartClear();
						break;
					case 4:
						// System.out.println("��ٱ��Ͽ� �׸� �߰��ϱ� : ");
						// menuCartAddItem(mBook);
						mTotalBook = totalFileToBookList();
						// mBookList = new Book[mTotalBook];
						mBookList = new ArrayList<Book>();
						menuCartAddItem(mBookList);
						break;
					case 5:
						// System.out.println("5. ��ٱ����� �׸� ���� ���̱�");
						menuCartRemoveItemCount();
						break;
					case 6:
						// System.out.println("6. ��ٱ����� �׸� �����ϱ�");
						menuCartRemoveItem();
						break;
					case 7:
						// System.out.println("7. ������ ǥ���ϱ�");
						menuCartBill();
						break;
					case 8:
						// System.out.println("8. ����");
						menuExit();
						quit = true;
						break;
					case 9:
						menuAdminLogin();
						break;
					}
				}

			} catch (CartException e) {
				System.out.println(e.getMessage());
				quit = true;
			} catch (Exception e) {
				System.out.println("�ùٸ��� ���� �޴� �������� �����մϴ�.");
				quit = true;
			}
		}

	}

	public static void menuIntroduction() {
		System.out.println("***********************************************");
		System.out.println(" 1. �� ���� Ȯ���ϱ� \t4. �ٱ��Ͽ� �׸� �߰��ϱ�");
		System.out.println(" 2. ��ٱ��� ��ǰ ��� ���� \t5. ��ٱ����� �׸� ���� ���̱�");
		System.out.println(" 3. ��ٱ��� ���� \t6. ��ٱ����� �׸� �����ϱ�");
		System.out.println(" 7. ������ ǥ���ϱ� \t8. ����");
		System.out.println(" 9. ������ �α���");
		System.out.println("***********************************************");
	}

	public static void menuGuestInfo(String name, int mobile) {
		System.out.println("���� �� ���� : ");
		// System.out.println("�̸� " + name + " ����ó " + mobile);
		// Person person = new Person(name, mobile);
		// System.out.println("�̸� " + person.getName() + " ����ó " + person.getPhone());
		System.out.println("�̸� " + mUser.getName() + "   ����ó " + mUser.getPhone());
	}

	public static void menuCartItemList() {

		/*
		 * System.out.println("��ٱ��� ��ǰ ��� :");
		 * System.out.println("---------------------------------------");
		 * System.out.println("    ����ID \t|     ���� \t|      �հ�"); for (int i = 0; i <
		 * mCartCount; i++) { System.out.print("    " + mCartItem[i].getBookID()
		 * +" \t| "); System.out.print("    " + mCartItem[i].getQuantity() + " \t| ");
		 * System.out.print("    " + mCartItem[i].getTotalPrice());
		 * System.out.println("  "); }
		 * System.out.println("---------------------------------------");
		 */
		if (mCart.mCartCount >= 0) {
			mCart.printCart();
		}
	}

	public static void menuCartClear() throws CartException {
		// System.out.println("��ٱ��� ����");
		if (mCart.mCartCount == 0)
			throw new CartException("��ٱ��Ͽ� �׸��� �����ϴ�");
		// System.out.println("��ٱ��Ͽ� �׸��� �����ϴ�");
		else {
			System.out.println("��ٱ��Ͽ� ��� �׸��� �����ϰڽ��ϱ�?  Y  | N ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			if (str.toUpperCase().equals("Y")) {
				System.out.println("��ٱ��Ͽ� ��� �׸��� �����߽��ϴ�");
				// mCart.mCartItem = new CartItemBook[NUM_BOOK];
				mCart.deleteBook();
			}
		}
	}

	public static void menuCartAddItem(ArrayList<Book> booklist) {
		// System.out.println("��ٱ��Ͽ� �׸� �߰��ϱ� : ");

		BookList(booklist);

		/*
		 * for (int i = 0; i < NUM_BOOK; i++) { for (int j = 0; j < NUM_ITEM; j++)
		 * System.out.print(book[i][j] + " | "); System.out.println(""); }
		 */
		mCart.printBookList(booklist);

		boolean quit = false;

		while (!quit) {

			System.out.print("��ٱ��Ͽ� �߰��� ������ ID�� �Է��ϼ��� :");

			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			boolean flag = false;
			int numId = -1;

			for (int i = 0; i < booklist.size(); i++) {
				if (str.equals(booklist.get(i).getBookId())) {
					numId = i;
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("��ٱ��Ͽ� �߰��ϰڽ��ϱ�?  Y  | N ");
				str = input.nextLine();
				if (str.toUpperCase().equals("Y")) {
					System.out.println(booklist.get(numId).getBookId() + " ������ ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
					// īƮ�� �ֱ�
					if (!isCartInBook(booklist.get(numId).getBookId())) {
						// mCartItem[mCartCount++] = new CartItem(book[numId]);
						// mCartItem[mCartCount++] = new CartItemBook(booklist[numId]);
						// mCart.mCartCount = mCartCount++;
						// mCartCount++;
						mCart.insertBook(booklist.get(numId));
					}
				}
				quit = true;
			} else
				System.out.println("�ٽ� �Է��� �ּ���");

		}
	}

	public static void menuCartRemoveItemCount() {
		System.out.println("5. ��ٱ����� �׸� ���� ���̱�");
	}

	public static void menuCartRemoveItem() throws CartException {
		// System.out.println("6. ��ٱ����� �׸� �����ϱ�");
		if (mCart.mCartCount == 0)
			throw new CartException("��ٱ��Ͽ� �׸��� �����ϴ�");
		// System.out.println("��ٱ��Ͽ� �׸��� �����ϴ�");
		else {
			menuCartItemList();
			boolean quit = false;
			while (!quit) {
				System.out.print("��ٱ��Ͽ��� ������ ������ ID�� �Է��ϼ��� :");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				boolean flag = false;
				int numId = -1;

				for (int i = 0; i < mCart.mCartCount; i++) {
					if (str.equals(mCart.mCartItem.get(i).getBookID())) {
						numId = i;
						flag = true;
						break;
					}
				}

				if (flag) {
					System.out.println("��ٱ����� �׸��� �����ϰڽ��ϱ�?  Y  | N ");
					str = input.nextLine();
					if (str.toUpperCase().equals("Y")) {

						System.out.println(mCart.mCartItem.get(numId).getBookID() + " ��ٱ��Ͽ��� ������ �����Ǿ����ϴ�.");
						// �迭�̵�
						/*
						 * CartItemBook[] cartItem =new CartItemBook[NUM_BOOK]; int num = 0;
						 * 
						 * for(int i = 0; i < mCartCount; i++) if (numId! = i) cartItem[num++] =
						 * mCart.mCartItem[i]; mCartCount= num; mCart.mCartCount= num; mCart.mCartItem =
						 * cartItem;
						 */
						mCart.removeCart(numId);
					}
					quit = true;
				} else
					System.out.println("�ٽ� �Է��� �ּ���");
			}
		}
	}

	public static void menuCartBill() throws CartException {
		// System.out.println("7. ������ ǥ���ϱ�");
		if (mCart.mCartCount == 0)
			throw new CartException("��ٱ��Ͽ� �׸��� �����ϴ�");
		// System.out.println("��񱸴Ͽ� �׸��� �����ϴ�");
		else {
			System.out.println("��۹��� ���� �������� �����ϱ�? Y  | N ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			if (str.toUpperCase().equals("Y")) {
				System.out.print("������� �Է����ּ��� ");
				String address = input.nextLine();
				printBill(mUser.getName(), String.valueOf(mUser.getPhone()), address);
			}

			else {
				System.out.print("��۹��� ������ �Է��ϼ��� ");
				String name = input.nextLine();
				System.out.print("��۹��� ���� ����ó�� �Է��ϼ��� ");
				String phone = input.nextLine();
				System.out.print("��۹��� ���� ������� �Է����ּ��� ");
				String address = input.nextLine();
				printBill(name, phone, address);
			}
		}
	}

	public static void menuExit() {
		System.out.println("8. ����");
	}

	public static void BookList(String[][] book) {

		book[0][0] = "ISBN1234";
		book[0][1] = "���� ���� JSP �� ���α׷���";
		book[0][2] = "27000";
		book[0][3] = "�۹̿�";
		book[0][4] = "�ܰ躰�� ���θ��� �����ϸ� ���� JSP �� ���α׷��� ";
		book[0][5] = "IT������";
		book[0][6] = "2018/10/08";

		book[1][0] = "ISBN1235";
		book[1][1] = "�ȵ���̵� ���α׷���";
		book[1][2] = "33000";
		book[1][3] = "���糲";
		book[1][4] = "�ǽ� �ܰ躰 ������ ���丵!";
		book[1][5] = "IT������";
		book[1][6] = "2022/01/22";

		book[2][0] = "ISBN1236";
		book[2][1] = "��ũ��ġ";
		book[2][2] = "22000";
		book[2][3] = "����";
		book[2][4] = "��ǻ�� ������ Ű��� ��� �ڵ�";
		book[2][5] = "��ǻ���Թ�";
		book[2][6] = "2019/06/10";
	}

	public static boolean isCartInBook(String bookId) {

		/*
		 * boolean flag = false; for (int i = 0; i < mCartCount; i++) { if (bookId ==
		 * mCartItem[i].getBookID()) {
		 * mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1); flag = true; } }
		 * return flag;
		 */
		return mCart.isCartInBook(bookId);
	}

	public static void menuAdminLogin() {
		System.out.println("������ ������ �Է��ϼ���");

		Scanner input = new Scanner(System.in);
		System.out.print("���̵� : ");
		String adminId = input.next();

		System.out.print("��й�ȣ : ");
		String adminPW = input.next();

		Admin admin = new Admin(mUser.getName(), mUser.getPhone());
		if (adminId.equals(admin.getId()) && adminPW.equals(admin.getPassword())) {

			String[] writeBook = new String[7];
			System.out.println("���� ������ �߰��ϰڽ��ϱ�?  Y  | N ");
			String str = input.next();

			if (str.toUpperCase().equals("Y")) {

				Date date = new Date();

				SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
				String strDate = formatter.format(date);
				writeBook[0] = "ISBN" + strDate;
				System.out.println("����ID : " + writeBook[0]);
				String st1 = input.nextLine();

				System.out.print("������ : ");
				writeBook[1] = input.nextLine();
				System.out.print("���� : ");
				writeBook[2] = input.nextLine();
				System.out.print("���� : ");
				writeBook[3] = input.nextLine();
				System.out.print("���� : ");
				writeBook[4] = input.nextLine();
				System.out.print("�о� : ");
				writeBook[5] = input.nextLine();
				System.out.print("������ : ");
				writeBook[6] = input.nextLine();

				try {
					FileWriter fw = new FileWriter("book.txt", true);

					for (int i = 0; i < 7; i++)
						fw.write(writeBook[i] + "\n");
					fw.close();
					System.out.println("�� ���� ������ ����Ǿ����ϴ�.");
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				System.out.println("�̸� " + admin.getName() + " ����ó " + admin.getPhone());
				System.out.println("���̵� " + admin.getId() + " ��й�ȣ " + admin.getPassword());
			}
		} else
			System.out.println("������ ������ ��ġ���� �ʽ��ϴ�.");
	}

	public static void BookList(ArrayList<Book> booklist) {
		setFileToBookList(booklist);
		/*
		 * booklist[0] = new Book("ISBN1234", "���� ���� JSP �� ���α׷���", 27000);
		 * booklist[0].setAuthor("�۹̿�");
		 * 
		 * booklist[0].setDescription("�ܰ躰�� ���θ��� �����ϸ� ���� JSP �� ���α׷��� ");
		 * booklist[0].setCategory("IT������"); booklist[0].setReleaseDate("2018/10/08");
		 * 
		 * booklist[1] = new Book("ISBN1235", "�ȵ���̵� ���α׷���", 33000);
		 * booklist[1].setAuthor("���糲"); booklist[1].setDescription("�ǽ� �ܰ躰 ������ ���丵!");
		 * booklist[1].setCategory("IT������"); booklist[1].setReleaseDate("2022/01/22");
		 * 
		 * booklist[2] = new Book("ISBN1236", "��ũ��ġ", 22000);
		 * booklist[2].setAuthor("����");
		 * booklist[2].setDescription("��ǻ�� ������ Ű��� ��� �ڵ�");
		 * booklist[2].setCategory("��ǻ���Թ�"); booklist[2].setReleaseDate("2019/06/10");
		 */
	}

	public static void printBill(String name, String phone, String address) {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println();
		System.out.println("---------------��� ���� �� ����----------------");
		System.out.println("���� : " + name + "   \t\t����ó : " + phone);
		System.out.println(" ����� : " + address + "t\t�߼��� : " + strDate);
		mCart.printCart();

		int sum = 0;
		for (int i = 0; i < mCart.mCartCount; i++)
			sum += mCart.mCartItem.get(i).getTotalPrice();

		System.out.println("\t\t\t�ֹ� �ѱݾ� : " + sum + "��\n");
		System.out.println("----------------------------------------------");
		System.out.println();
	}

	public static int totalFileToBookList() {

		try {

			FileReader fr = new FileReader("book.txt");
			BufferedReader reader = new BufferedReader(fr);

			String str;

			int num = 0;

			while ((str = reader.readLine()) != null) {
				if (str.contains("ISBN"))
					++num;
			}

			reader.close();
			fr.close();
			return num;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public static void setFileToBookList(ArrayList<Book> booklist) {
		try {
			FileReader fr = new FileReader("book.txt");
			BufferedReader reader = new BufferedReader(fr);

			String str2;
			String[] readBook = new String[7];
			// int count = 0;

			while ((str2 = reader.readLine()) != null) {

				if (str2.contains("ISBN")) {
					readBook[0] = str2;
					readBook[1] = reader.readLine();
					readBook[2] = reader.readLine();
					readBook[3] = reader.readLine();
					readBook[4] = reader.readLine();
					readBook[5] = reader.readLine();
					readBook[6] = reader.readLine();
				}

//				booklist[count++] = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]), readBook[3],
				// readBook[4], readBook[5], readBook[6]);
				Book bookitem = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]), readBook[3],
						readBook[4], readBook[5], readBook[6]);
				booklist.add(bookitem);
			}

			reader.close();
			fr.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}