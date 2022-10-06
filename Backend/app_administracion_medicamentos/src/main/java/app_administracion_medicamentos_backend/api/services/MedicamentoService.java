package app_administracion_medicamentos_backend.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app_administracion_medicamentos_backend.api.dao.MedicamentoDao;
import app_administracion_medicamentos_backend.api.dto.entities.Medicamento;
import app_administracion_medicamentos_backend.api.interfaces.services.IMedicamentoService;

@Service
public class MedicamentoService implements IMedicamentoService<Medicamento> {

	@Autowired
	MedicamentoDao medicamentoDao;

	@Override
	public List<Medicamento> getAll() {
		List<Medicamento> medicamentos = this.medicamentoDao.findAll();
		return medicamentos;
	}

	@Override
	public Medicamento getById(Long id) {
		return this.medicamentoDao.getById(id);
	}

	@Override
	public Medicamento createOrUpdate(Medicamento entity) {
		try {
			Medicamento medicamento = this.medicamentoDao.save(entity);
			return medicamento;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Medicamento deleteById(Long id) {
		Medicamento medicamento = getById(id);
		if(medicamento != null) {
			this.medicamentoDao.deleteById(medicamento.getId_medicamento());
			return medicamento;
		}
		return null;
	}

	@Override
	public List<Medicamento> getAllByClienteId(Long id_cliente) {
		return this.medicamentoDao.getAllByClienteId(id_cliente);
	}

}
