package model;

public class mensagem {

	public class Messagem {
		private int id;
		private String rementente;
		private String destinatario;
		private String mensagem;

		public Messagem(int id, String rementente, String destinatario, String mensagem) {
			this.id = id;
			this.rementente = rementente;
			this.destinatario = destinatario;
			this.mensagem = mensagem;
		}

		public String getRementente() {
			return rementente;
		}

		public void setRementente(String rementente) {
			this.rementente = rementente;
		}

		public String getDestinatario() {
			return destinatario;
		}

		public void setDestinatario(String destinatario) {
			this.destinatario = destinatario;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
}
