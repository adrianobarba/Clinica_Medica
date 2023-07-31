package adriano.barbosa.app.domain.paciente;

import adriano.barbosa.app.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String telefone,
        DadosEndereco endereco) {
}
