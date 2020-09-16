package com.baizhi.entity;

import java.util.Date;

public class Book {
	private Integer id;
	private String name;
	private String author;
	private String cover;
	private String press;
	private Date press_date;
	private String edition;
	private Date print_date;
	private String impression;
	private String isbn;
	private String word_num;
	private String page_num;
	private String size;
	private String paper;
	private String pack;
	private Double price;
	private Double dprice;
	private Date create_date; 
	private String editor_recommend;
	private String content_abstract;
	private String author_abstract;
	private String director;
	private String media_commentary;
	private String category_id;
	private Integer sale;
	private Integer stock;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String name, String author, String cover,
			String press, Date press_date, String edition, Date print_date,
			String impression, String isbn, String word_num, String page_num,
			String size, String paper, String pack, Double price,
			Double dprice, Date create_date, String editor_recommend,
			String content_abstract, String author_abstract, String director,
			String media_commentary, String category_id, Integer sale,
			Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.press_date = press_date;
		this.edition = edition;
		this.print_date = print_date;
		this.impression = impression;
		this.isbn = isbn;
		this.word_num = word_num;
		this.page_num = page_num;
		this.size = size;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.create_date = create_date;
		this.editor_recommend = editor_recommend;
		this.content_abstract = content_abstract;
		this.author_abstract = author_abstract;
		this.director = director;
		this.media_commentary = media_commentary;
		this.category_id = category_id;
		this.sale = sale;
		this.stock = stock;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPress_date() {
		return press_date;
	}
	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getWord_num() {
		return word_num;
	}
	public void setWord_num(String word_num) {
		this.word_num = word_num;
	}
	public String getPage_num() {
		return page_num;
	}
	public void setPage_num(String page_num) {
		this.page_num = page_num;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(java.util.Date date) {
		this.create_date = date;
	}
	public String getEditor_recommend() {
		return editor_recommend;
	}
	public void setEditor_recommend(String editor_recommend) {
		this.editor_recommend = editor_recommend;
	}
	public String getContent_abstract() {
		return content_abstract;
	}
	public void setContent_abstract(String content_abstract) {
		this.content_abstract = content_abstract;
	}
	public String getAuthor_abstract() {
		return author_abstract;
	}
	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMedia_commentary() {
		return media_commentary;
	}
	public void setMedia_commentary(String media_commentary) {
		this.media_commentary = media_commentary;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", cover=" + cover + ", press=" + press + ", press_date="
				+ press_date + ", edition=" + edition + ", print_date="
				+ print_date + ", impression=" + impression + ", isbn=" + isbn
				+ ", word_num=" + word_num + ", page_num=" + page_num
				+ ", size=" + size + ", paper=" + paper + ", pack=" + pack
				+ ", price=" + price + ", dprice=" + dprice + ", create_date="
				+ create_date + ", editor_recommend=" + editor_recommend
				+ ", content_abstract=" + content_abstract
				+ ", author_abstract=" + author_abstract + ", director="
				+ director + ", media_commentary=" + media_commentary
				+ ", category_id=" + category_id + ", sale=" + sale
				+ ", stock=" + stock + "]";
	}
	
}
