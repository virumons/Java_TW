package practices.oop;

import java.util.*; //To include Scanner,Set & HashSet classes

class SetOperations {
	Set<Integer> a = new HashSet<Integer>(); // Instantiate a to refer to set1 from main
	Set<Integer> b = new HashSet<Integer>(); // Instantiate b to refer to set2 from main

	SetOperations(Set<Integer> p, Set<Integer> q) { // Constructor
		a = p;
		b = q;

		System.out.println("Elements of first set are: ");
		System.out.println(a);

		System.out.println("Elements of second set are: ");
		System.out.println(b);
	}

	void union() {
		Set<Integer> m = new HashSet<Integer>(a);
		m.addAll(b); // Adds all elements of set b to set a without repetition
		System.out.println("The union of the two sets are: ");
		System.out.println(m);
	}

	void Intersection() {
		Set<Integer> n = new HashSet<Integer>(a);
		n.retainAll(b);
		System.out.println(n);
	}

	void difference() {
		Set<Integer> o = new HashSet<Integer>(a);
		o.retainAll(b); // To find intersection of a and b

		Set<Integer> r = new HashSet<Integer>(a);
		r.removeAll(o); // remove the common elements between set1 & 2 to get difference
		System.out.println(r);
	}

	/**
	 * 
	 */
	void powerSet() {
		// Initially find union of two sets
		Set<Integer> u = new HashSet<Integer>(a);
		u.addAll(b); // Adds all elements of set b to set a without repetition
		double e = u.size();
		double power = Math.pow(2, e); //To calculate total number of subsets of set

		Integer[] arr = new Integer[u.size()];
		u.toArray(arr); // To convert set to array

		for (int i = 0; i < power - 1; i++) {

			for (int j = 0; j < e; j++) {
				// Check if jth bit in the counter is set If set then print jth element from set
				if ((i & (1 << j)) > 0)
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		System.out.println("[ ]"); // To include null set
		System.out.println(u);
	}
}

public class program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Set<Integer> s1 = new HashSet<Integer>(); // instantiate set1 of type integer
		Set<Integer> s2 = new HashSet<Integer>(); // instantiate set2 of type integer

		// Deque<Integer> res = new ArrayDeque<>();

		System.out.println("Enter size of set 1");
		int m = sc.nextInt();

		System.out.println("Enter elements of the first set");
		for (int i = 0; i < m; i++) {
			s1.add(sc.nextInt());
		}

		System.out.println("Enter size of set 2");
		int n = sc.nextInt();

		System.out.println("Enter elements of the second set");
		for (int i = 0; i < n; i++) {
			s2.add(sc.nextInt());
		}

		SetOperations so = new SetOperations(s1, s2);

		System.out.println("Enter 1 to find union of sets");
		System.out.println("Enter 2 to find intersection of sets");
		System.out.println("Enter 3 to find difference of sets");
		System.out.println("Enter 4 to find power set of sets");
		System.out.println("Enter 5 to exit");

		int z = sc.nextInt();

		switch (z) {
		case 1:
			so.union();
			break;
		case 2:
			so.Intersection();
			break;
		case 3:
			so.difference();
			break;

		case 4:
			so.powerSet();
			break;

		case 5:
			System.exit(0);

		}
	}

}
