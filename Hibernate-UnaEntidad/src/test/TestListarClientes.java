package test;

import java.util.*;

import datos.Cliente;
import negocio.ClienteABM;

public class TestListarClientes {

	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();

		List<Cliente> lstCliente = abm.traerCliente();

		for (int i = 0; i < lstCliente.size(); i++) {
			System.out.println(lstCliente.get(i).toString());
		}

	}

}
