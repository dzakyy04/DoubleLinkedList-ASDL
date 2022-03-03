
import java.util.Scanner;

public class Double2LinkedList {

	Node head;
	Node tail;
	int length;

   class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
		}
	}
	
	public boolean isEmpty() {
		return length == 0;
	}

	public int length() {
		return length;
	}

	
// 	Method menambah tambah data awal
	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.prev = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}

// 	Method menambah data tengah
	public void add(int position, int data) {

		Node node = new Node(data);

		if (position == 0) {
			node.next = head;
			head = node;
		} else {
			Node prev = head;
			int count = 1;

			while (count < position) {
				prev = prev.next;
				count++;
			}

			Node current = prev.next;
			prev.next = node;
			node.next = current;
		}

	}
	
// 	Method menambah data akhir
	public void addLast(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		length++;
	}
	
//Method Hitung Bilangan Node
    int countOfNode(Node head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
//Method Hapus Data Awal
    public void removeFirst() {
		Node node = head.next;
		node.prev = null;
		head = node;
	}
// Method Hapus Data Tengah
    Node removeMid(Node head) {
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return null;
		}

		Node copyHead = head;

		int count = countOfNode(head);

		int mid = count / 2;

		while (mid-- > 1) {
			head = head.next;
		}

		head.next = head.next.next;

		return copyHead;
	}
//Method Hapus Data Akhir
    public Node removeLast() {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return null;
		}
		Node second_last = head;
		while (second_last.next.next != null) {
			second_last = second_last.next;
		}
		second_last.next = null;

		return head;
	}
//Method Print LinkedList
    public void printList(boolean asc) {
		Node n = null;
		if (asc)
			n = head;
		else
			n = tail;
		System.out.print("[ ");

		while (n != null) {
			System.out.print(n.data + " ");
			if (asc)
				n = n.next;
			else
				n = n.prev;
		}
		System.out.println("]");
	}








//Menu Utama
    public void manual() {
		System.out.println("*****Berada di Pilihan Awal*****");
		System.out.println("1. Tambah Data");
		System.out.println("2. Hapus Data");
		System.out.println("3. Pencarian/Pengubahan Data");
		System.out.println("4. Kembali");
		System.out.println("*****Berada di Pilihan Awal*****");
		Scanner input = new Scanner(System.in);
		int pilih = input.nextInt();
		switch (pilih) {
		case 1:
			removeFirst();// Diganti Untuk Menu Tambah Data Node (Dewa)
			break;
		case 2:
			menuPenghapusanNode();
			break;
		case 3:
			removeLast();// Diganti untuk menu pencarian/pengubahaan data (louis)
			break;
		}
	}
	
//    Menu Tambah Data
	public void menuTambahData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n*** PILIHAN TAMBAH DATA ***");
		System.out.println("1. Tambah data awal");
		System.out.println("2. Tambah data tengah");
		System.out.println("3. Tambah data akhir");
		System.out.println("4. Cetak data");

		boolean lanjut = true;
		boolean ulang = true;
		while (lanjut) {
			System.out.print("Silahkan pilih [1/2/3] : ");
			char pilih = sc.next().charAt(0);
			int value;

			switch (pilih) {
			case '1':
				addFirst(value = sc.nextInt());
				lanjut = false;
				break;
			case '2':
				add(sc.nextInt(), sc.nextInt());
				lanjut = false;
				break;
			case '3':
				addLast(sc.nextInt());
				lanjut = false;
				break;
			case '4':
				printList(true);
				lanjut = false;
				break;
			default:
				System.err.println("\nPilihan anda salah");
				break;
			}
		}
	}
	
//Menu Penghapus Data
    public void menuPenghapusanNode() {
		Scanner input = new Scanner(System.in);

		System.out.println("*****PILIHAN HAPUS DATA NODE*****");
		System.out.println("1. Hapus Data Awal");
		System.out.println("2. Hapus Data Tengah");
		System.out.println("3. Hapus Data Akhir");
		System.out.println("4. Cetak Data");
		System.out.println("5. Kembali");
		int pilih = input.nextInt();

		boolean x = true;
		switch (pilih) {
		case 1:
			while (x == true) {
				System.out.print("Apakah anda yakin ingin menghapus data pertama? (y/n)");
				String yesNo = input.next();
				if (yesNo.equalsIgnoreCase("y")) {
					removeFirst();
				} else {
					menuPenghapusanNode();
					break;
				}
			}
		case 2: {
			System.out.print("Apakah anda yakin ingin menghapus data tengah? (y/n)");
			String yesNo2 = input.next();
			if (yesNo2.equalsIgnoreCase("y")) {
				removeMid(head);
			} else {
				menuPenghapusanNode();
				break;
			}
		}
		case 3:
			while (x == true) {
				System.out.print("Apakah anda yakin ingin menghapus data terakhir? (y/n)");
				String yesNo1 = input.next();
				if (yesNo1.equalsIgnoreCase("y")) {
					removeLast();
				} else {
					menuPenghapusanNode();
					break;
				}
			}
		case 4: {
			printList(true);
			System.out.print("Kembali?");
			String yesNo = input.next();
			menuPenghapusanNode();
			break;
		}
		case 5:
			manual();
			break;
		default:
			System.out.print("Silakan pilih antara [1/2/3/4/5]");
			menuPenghapusanNode();
		}

	}
}
