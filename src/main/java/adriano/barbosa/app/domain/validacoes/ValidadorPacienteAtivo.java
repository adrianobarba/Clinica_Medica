package adriano.barbosa.app.domain.validacoes;

import adriano.barbosa.app.domain.ValidacaoException;
import adriano.barbosa.app.domain.consulta.DadosAgendamentoConsulta;
import adriano.barbosa.app.domain.paciente.DadosAtualizacaoPaciente;
import adriano.barbosa.app.domain.paciente.Paciente;
import adriano.barbosa.app.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo= repository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluido");
        }
    }
}
