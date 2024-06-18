package jp.te4a.spring.boot.myapp12.mybootapp12;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.te4a.spring.boot.myapp12.mybootapp12.BookValid.TestValid;
import jp.te4a.spring.boot.myapp12.mybootapp12.WritterValid.Writter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated

public class BookForm {
    private Integer id;
    @NotNull
    @Size(min = 3)
    @TestValid(param = "abc")
    private String title;
    @Size(min = 3, max = 20)
    @Writter(ok = "東北タロウ")
    private String writter;
    private String publisher;
    @Min(0)
    private Integer price;
}