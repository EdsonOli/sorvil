package testesunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projeto_sorvil.controller.ControladorCards;
import projeto_sorvil.model.Card;

class ControladorCardsTest {

	@Test
	void testNovoCard() {
		ControladorCards contCard = new ControladorCards();
		Card card = new Card("Qualquer coisa", null, null, null, null, null, false, 0);
		boolean resultado = contCard.novoCard(card);
	}

	@Test
	void testListarCardsPublicos() {
		fail("Not yet implemented");
	}

	@Test
	void testListarCardsPublicosLivro() {
		fail("Not yet implemented");
	}

	@Test
	void testListarCardsPublicosUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testListarCardsUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testListarCardsLivroUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCard() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarPorTitulo() {
		fail("Not yet implemented");
	}

}
