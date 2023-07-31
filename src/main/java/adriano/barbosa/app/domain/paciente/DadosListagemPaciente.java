package adriano.barbosa.app.domain.paciente;

import adriano.barbosa.app.domain.medico.Especialidade;
import adriano.barbosa.app.domain.paciente.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }
}
