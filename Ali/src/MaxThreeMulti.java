import java.util.Scanner;

/*
61
3472 -7098 -9281 7789 7955 6101 5051 7778 3090 7423 -7151 5652 1595 -8094 677 -8324 8347 -2482 9313 -9338 -3157 8559 6945 3618 3087 121 -8468 3225 1356 6939 2799 -7231 -6309 -5453 633 -8689 -4776 2714 -2743 -1409 5918 -3333 1803 8330 -2206 -6117 -4486 -7903 -4375 -3739 2897 8056 -5864 -522 7451 -4541 -2813 5790 -532 -6517 925
*/
public class MaxThreeMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		long[] ints = new long[length];
		scanner.nextLine();
		for (int i = 0; i < length; i++) {
			ints[i] = scanner.nextLong();
		}
		System.out.println(getThreeMax(ints));

	}

	private static long getThreeMax(long[] ints) {
		// TODO Auto-generated method stub
		int n = ints.length;
		if (n == 3)
			return ints[0] * ints[1] * ints[2];
		long max1 = 0;
		long max2 = max1, max3 = max1, min1 = max1, min2 = max1;
		for (long i : ints) {
			if (i >= max1) {
				max2 = max1;
				max3 = max2;
				max1 = i;
			} else if (i >= max2) {
				max3 = max2;
				max2 = i;

			} else if (i >= max3)
				max3 = i;
			if (i <= min1) {
				min2 = min1;
				min1 = i;

			} else if (i <= min2) {
				min2 = i;
			}

		}
		return Math.max(max3 * max2 * max1, min1 * min2 * max1);
	}

}
