package model;

public class QueryConstructor {
	private boolean allBooks;
	private String category;
	private String searchTerm;
	private boolean sort;
	private boolean sortNewestToOldest;
	private boolean sortOldestToNewest;
	private boolean sortReviewHighToLow;
	private boolean sortReviewLowtoHigh;
	private boolean sortPriceHighToLow;
	private boolean sortPriceLowtoHigh;
	private boolean filter;
	private double priceFilterLow;
	private double priceFilterHigh;
	private double ratingFilter;
	private String categoryFilter;

	public QueryConstructor() {
		super();
		this.allBooks = false;
		this.category = null;
		this.searchTerm = null;
		this.sort = false;
		this.sortNewestToOldest = false;
		this.sort = false;
		this.sortNewestToOldest = false;
		this.sortOldestToNewest = false;
		this.sortReviewHighToLow = false;
		this.sortReviewLowtoHigh = false;
		this.sortPriceHighToLow = false;
		this.sortPriceLowtoHigh = false;
		this.filter = false;
		this.priceFilterLow = 0;
		this.priceFilterHigh = -1;
		this.ratingFilter = 0;
		this.categoryFilter = null;
	}
	
	public void reset() {
		this.allBooks = false;
		this.category = null;
		this.searchTerm = null;
	}

	public void resetSort() {
		this.sort = false;
		this.sortNewestToOldest = false;
		this.sort = false;
		this.sortNewestToOldest = false;
		this.sortOldestToNewest = false;
		this.sortReviewHighToLow = false;
		this.sortReviewLowtoHigh = false;
		this.sortPriceHighToLow = false;
		this.sortPriceLowtoHigh = false;
	}
	
	public void resetFilter() {
		this.filter = false;
		this.priceFilterLow = 0;
		this.priceFilterHigh = 0;
		this.ratingFilter = 0;
		this.categoryFilter = null;
	}
	
	public boolean isAllBooks() {
		return allBooks;
	}

	public void setAllBooks(boolean allBooks) {
		this.allBooks = allBooks;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
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

	public double getPriceFilterHigh() {
		return priceFilterHigh;
	}

	public void setPriceFilterHigh(double priceFilterHigh) {
		this.priceFilterHigh = priceFilterHigh;
	}
	
	public double getRatingFilter() {
		return ratingFilter;
	}

	public void setRatingFilter(double ratingFilter) {
		this.ratingFilter = ratingFilter;
	}

	public String getCategoryFilter() {
		return categoryFilter;
	}

	public void setCategoryFilter(String categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	
	
	
}
