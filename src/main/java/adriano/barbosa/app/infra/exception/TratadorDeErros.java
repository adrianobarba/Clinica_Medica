package adriano.barbosa.app.infra.exception;

import adriano.barbosa.app.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

     @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
         return ResponseEntity.notFound().build();

     }
    @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
         var erros = ex.getFieldErrors();

         return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());

     }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErrorRegraDeNegocio(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());

    }

     private record DadosErroValidacao(String campo, String mensagem) {
         public DadosErroValidacao(FieldError erro) {
             this(erro.getField(), erro.getDefaultMessage());
         }
     }
}
