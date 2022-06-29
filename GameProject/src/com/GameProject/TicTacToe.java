package com.GameProject;

import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe
{

	static HashSet<Integer> user_set = new HashSet<Integer>();
	static HashSet<Integer> computer_set = new HashSet<Integer>();

	public static void main(String[] args)
	{

		char[][] g_board =
		{

				{ '-', '|', '-', '|', '-' },
				{ ' ', '|', ' ', '|', ' ' },
				{ '-', '|', '-', '|', '-' },
				{ ' ', '|', ' ', '|', ' ' },
				{ '-', '|', '-', '|', '-' } 
		};
		
		System.out.println("\n");
		
		print_board(g_board);

		Scanner input = new Scanner(System.in);

		while (true)
		{
			System.out.println("Enter Values From 1-9:");
			
			int user_position = input.nextInt();

			while (user_set.contains(user_position) || computer_set.contains(user_position))
			{
				System.out.println("Retry Enter Values From 1-9");
				user_position = input.nextInt();
			}

			print_holder(g_board, user_position, "YOU");



			int computer_position = Generate_Random();
			while (user_set.contains(computer_position) || computer_set.contains(computer_position))
			{
				System.out.println("Retry Enter Values From 1-9");
				computer_position = Generate_Random();
			}

			print_holder(g_board, computer_position, "COMPUTER");
			
			/**Check winner**/
			String result = check_winner();
			if (result != null)
			{
				System.out.println(result);
				break;
			}

		}
	}
	

	public static int Generate_Random()
	{

		int maximum = 9;
		int minimum = 1;

		int range = maximum - minimum + 1;

		int result = (int) (Math.random() * range) + minimum;
		return result;
	}

	static String check_winner()
	{
		
		String result = null;
		
		HashSet<Integer> r1 = new HashSet<Integer>();
		r1.add(1);
		r1.add(2);
		r1.add(3);
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2.add(4);
		r2.add(5);
		r2.add(6);
		HashSet<Integer> r3 = new HashSet<Integer>();
		r3.add(7);
		r3.add(8);
		r3.add(9);
		HashSet<Integer> c1 = new HashSet<Integer>();
		c1.add(1);
		c1.add(4);
		c1.add(7);
		HashSet<Integer> c2 = new HashSet<Integer>();
		c2.add(2);
		c2.add(5);
		c2.add(8);
		HashSet<Integer> c3 = new HashSet<Integer>();
		c3.add(3);
		c3.add(6);
		c3.add(9);
		HashSet<Integer> d1 = new HashSet<Integer>();
		d1.add(1);
		d1.add(5);
		d1.add(9);
		HashSet<Integer> d2 = new HashSet<Integer>();
		d2.add(3);
		d2.add(5);
		d2.add(7);

		HashSet<HashSet> set = new HashSet<HashSet>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(d1);
		set.add(d2);
		
		for (HashSet R : set)
		{
			if (user_set.containsAll(R))
			{
				result =  "YOU WIN";
			}
			else if (computer_set.containsAll(R))
			{
				result =  "YOU LOST";
			}
				

		}
		if (user_set.size() + computer_set.size() == 9)
		{
			result =  "DRAW";
		}
			
		return result;

	}

	static void print_board(char[][] g_board)
	{
		for (int r = 0; r < g_board.length; r++)
		{

			for (int c = 0; c < g_board[0].length; c++)
			{
				System.out.print(g_board[r][c]);

			}
			System.out.println();

		}
	}

	static void print_holder(char[][] g_board, int position, String user)
	{
		char symbol = 'X';

		if (user.equals("YOU"))
		{
			symbol = 'X';
			user_set.add(position);

		} else if (user.equals("COMPUTER"))
		{
			symbol = 'O';
			computer_set.add(position);

		}

		switch (position)
		{
		case 1:
			g_board[0][0] = symbol;
			break;
		case 2:
			g_board[0][2] = symbol;
			break;
		case 3:
			g_board[0][4] = symbol;
			break;
		case 4:
			g_board[2][0] = symbol;
			break;
		case 5:
			g_board[2][2] = symbol;
			break;
		case 6:
			g_board[2][4] = symbol;
			break;
		case 7:
			g_board[4][0] = symbol;
			break;
		case 8:
			g_board[4][2] = symbol;
			break;
		case 9:
			g_board[4][4] = symbol;
			break;

		default:
			System.out.println("Invalid Input");

		}
		print_board(g_board);
		
		System.out.println("\n");

	}

}
