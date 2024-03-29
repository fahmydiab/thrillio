package com.thrillio;

import java.util.Iterator;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.BookmarkManager;
import com.thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1. Loading data ...");
		DataStore.loadDatat();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		System.out.println("Printing data ...");

		printUserData();
		printBookmarkData();

	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark);
			}
		}
	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);

		}
	}

	private static void startBookmarking() {
		System.out.println("\n2. Bookmarking ...");
		for(User user : users) {
			View.bookmark(user, bookmarks);
		}

	}

	public static void main(String[] args) {
		loadData();
		startBookmarking();

	}

}
