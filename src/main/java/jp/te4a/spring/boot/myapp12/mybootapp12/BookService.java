package jp.te4a.spring.boot.myapp12.mybootapp12;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  BookRepository bookRepository;

  public BookForm create(BookForm bookForm) {
    BookBean bookBean = new BookBean();
    BeanUtils.copyProperties(bookForm, bookBean);
    bookRepository.save(bookBean);
    return bookForm;
  }

  public BookForm update(BookForm bookForm) {
    BookBean bookBean = new BookBean();
    BeanUtils.copyProperties(bookForm, bookBean);
    bookRepository.save(bookBean);
    return bookForm;
  }

  public void delete(Integer id) {
    bookRepository.deleteById(id);
  }

  public List<BookForm> findAll() {
    List<BookBean> beanList = bookRepository.findAll();
    List<BookForm> formList = new ArrayList<>();
    for (BookBean bookBean : beanList) {
      BookForm bookForm = new BookForm();
      BeanUtils.copyProperties(bookBean, bookForm);
      formList.add(bookForm);
    }
    return formList;
  }

  public BookForm findOne(Integer id) {
    Optional<BookBean> bookBean = findById(id);
    BookForm bookForm = new BookForm();
    BeanUtils.copyProperties(bookBean, bookForm);
    return bookForm;
  }

  public Optional<BookBean> findById(Integer id) {
    return bookRepository.findById(id);
  }

}
