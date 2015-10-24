package br.sceweb.teste;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static EmpresaDAO empresaDAO;
    static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * obj - verificar o comportamento do sistema na consulta de empresa com sucesso 
	 */
	@Test
	public void CT01UC02FBConsultarEmpresa_com_sucesso() {
		empresaDAO.adiciona(empresa);
		assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
		empresaDAO.exclui("89424232000180");
	}
	@Test
	public void CT02UC02FBConsultarEmpresa_com_sucesso() {
		empresaDAO.adiciona(empresa);
		Empresa empresa2 = new Empresa();
		empresa2.setNomeDaEmpresa("empresa x");
		empresa2.setCnpj("76866310000155");
		empresa2.setNomeFantasia("empresa x");
		empresa2.setEndereco("rua taquari");
		empresa2.setTelefone("2222");
		empresaDAO.adiciona(empresa2);
		assertEquals(2,empresaDAO.consultaEmpresas().size());
		empresaDAO.exclui("89424232000180");
		empresaDAO.exclui("76866310000155");
	}
	
	/**
	 * obj - verificar o comportamento do sistema na consulta de empresa com sucesso pelo controle 
	 */
	@Test
	public void CT03UC02FBConsultarEmpresa_com_sucesso() {
		empresaDAO.adiciona(empresa);
		assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
		empresaDAO.exclui("89424232000180");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
		empresaDAO.exclui("76866310000155");
	}
}

