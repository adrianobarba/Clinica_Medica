package adriano.barbosa.app.domain.medico;

import adriano.barbosa.app.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String telefone,
        DadosEndereco endereco) {
}
