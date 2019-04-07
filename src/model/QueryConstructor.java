package model;

public class QueryConstructor {
	private boolean allBooks;
	private String searchItem;
	private String category;
	private boolean sort;
	private boolean sortNewestToOldest;
	private boolean sortOldestToNewest;
	private boolean sortReviewHighToLow;
	private boolean sortReviewLowtoHigh;
	private boolean sortPriceHighToLow;
	private boolean sortPriceLowtoHigh;
	private boolean filter;
	private double priceFilterLow;
	private double reviewFilter;
	private String categoryFilter;

	public QueryConstructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAllBooks() {
		return allBooks;
	}

	public void setAllBooks(boolean allBooks) {
		this.allBooks = allBooks;
	}

	public String getSearchItem() {
		return searchItem;
	}

	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isSort() {
		return sort;
	}

	public void setSort(boolean sort) {
		this.sort = sort;
	}

	public boolean isSortNewestToOldest() {
		return sortNewestToOldest;
	}

	public void setSortNewestToOldest(boolean sortNewestToOldest) {
		this.sortNewestToOldest = sortNewestToOldest;
	}

	public boolean isSortOldestToNewest() {
		return sortOldestToNewest;
	}

	public void setSortOldestToNewest(boolean sortOldestToNewest) {
		this.sortOldestToNewest = sortOldestToNewest;
	}

	public boolean isSortReviewHighToLow() {
		return sortReviewHighToLow;
	}

	public void setSortReviewHighToLow(boolean sortReviewHighToLow) {
		this.sortReviewHighToLow = sortReviewHighToLow;
	}

	public boolean isSortReviewLowtoHigh() {
		return sortReviewLowtoHigh;
	}

	public void setSortReviewLowtoHigh(boolean sortReviewLowtoHigh) {
		this.sortReviewLowtoHigh = sortReviewLowtoHigh;
	}

	public boolean isSortPriceHighToLow() {
		return sortPriceHighToLow;
	}

	public void setSortPriceHighToLow(boolean sortPriceHighToLow) {
		this.sortPriceHighToLow = sortPriceHighToLow;
	}

	public boolean isSortPriceLowtoHigh() {
		return sortPriceLowtoHigh;
	}

	public void setSortPriceLowtoHigh(boolean sortPriceLowtoHigh) {
		this.sortPriceLowtoHigh = sortPriceLowtoHigh;
	}

	public boolean isFilter() {
		return filter;
	}

	public void setFilter(boolean filter) {
		this.filter = filter;
	}

	public double getPriceFilterLow() {
		return priceFilterLow;
	}

	public void setPriceFilterLow(double priceFilterLow) {
		this.priceFilterLow = priceFilterLow;
	}

	public double getReviewFilter() {
		return reviewFilter;
	}

	public void setReviewFilter(double reviewFilter) {
		this.reviewFilter = reviewFilter;
	}

	public String getCategoryFilter() {
		return categoryFilter;
	}

	public void setCategoryFilter(String categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	
	
	
}
