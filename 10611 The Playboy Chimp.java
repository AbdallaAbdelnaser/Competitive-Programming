import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt(), arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();

		int q = in.nextInt();
					
		while (q-- > 0) { //q*log(n) 
			int target = in.nextInt(), left = 0, right = n - 1, mid, ans = -1;

			while (left <= right) {
				mid = (left + right) / 2;

				if (arr[mid] >= target)
					right = mid - 1; // skip it
				else {
					ans = arr[mid];
					left = mid + 1;
				}
			}

			out.print(ans == -1 ? "X " : ans + " ");

			left = 0;
			right = n - 1;
			ans = -1;

			while (left <= right) {
				mid = (left + right) / 2;

				if (arr[mid] <= target)
					left = mid + 1; // skip it
				else {
					right = mid - 1;
					ans = arr[mid];
				}

			}

			out.println(ans == -1 ? "X" : ans);

		}

		out.close();

	}
}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	public FastReader(File f) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(f));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return st.nextToken();

	}

	int nextInt() {

		return Integer.parseInt(next());
	}

	double nextDouble() {

		return Double.parseDouble(next());
	}

	long nextLong() {

		return Long.parseLong(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return str;

	}

	boolean ready() throws IOException {
		return br.ready();
	}
}
