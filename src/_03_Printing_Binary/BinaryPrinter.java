package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */

	
	public static void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		
		// Shift b seven bits to the right
		// Use the & operator to "mask" the bit in the one's place
		// This can be done by "anding" (&) it with the value of 1
		// Print the result using System.out.print (NOT System.out.println)
		byte mask= (byte) 0b10000000;
		String biStr="";
		while (mask!=0) {
		if((b&mask)!=0) {
			biStr+="1";
		}else {
			biStr+=0;
		}
		mask=(byte)((mask & 0xFF)>>>1);
		}
	System.out.print(biStr);
	}
	
	public static void printShortBinary(short s) {
		// Create 2 byte variables
		byte v1;
		byte v2;
		
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		v1=(byte) ((s & 0xFF00)>>8);
		v2=(byte) (s & 0xFF);
			System.out.println();
		printByteBinary(v1);
		printByteBinary(v2);

		//System.out.println(v1+","+v2);

		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
	}
	
	public static void printIntBinary(int i) {
		// Create 2 short variables
		short s1;
		short s2;
		
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		s1=(byte) ((i & 0xFFFF00)>>16);
		s2=(byte) (i & 0xFFFF);
			System.out.println();
		printShortBinary(s1);
		printShortBinary(s2);
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
	}
	
	public static void printLongBinary(long l) {
		// Use the same method as before to complete this method
		int i1;
		int i2;
		
		i1=(byte) ((l & 0xFFFFFF00)>>16);
		i2=(byte) (l & 0xFFFFFF);
			System.out.println();
		printIntBinary(i1);
		printIntBinary(i2);
	}
	
	public static void main(String[] args) {
		// Test your methods here
		byte bt=(byte)0b0111;
		printByteBinary(bt);
		printShortBinary((short) 512);
		printIntBinary((int)327);
		printLongBinary((long)419);
	}
}
