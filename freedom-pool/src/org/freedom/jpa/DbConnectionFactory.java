package org.freedom.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.freedom.util.resource.ResourceException;
import org.freedom.util.resource.ResourceKey;

/**
 * Classe de conex�o com o banco de dados especifica��o JPA <BR>
 * Projeto: org.freedom.jpa <BR>
 * Pacote: org.freedom.jpa <BR>
 * Classe: @(#)DbConnectionFactory.java <BR>
 * <BR>
 * Este programa � licenciado de acordo com a LGPL (Lesser General Public
 * License), <BR>
 * vers�o 2.1, Fevereiro de 1999 <BR>
 * A LGPL deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste
 * Programa. <BR>
 * Caso uma c�pia da LGPL n�o esteja dispon�vel junto com este Programa, voc�
 * pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <a
 * href=http://creativecommons.org/licenses/LGPL/2.1/legalcode.pt> Creative
 * Commons</a> <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa �
 * preciso estar de acordo com os termos da LGPL. <BR>
 * <BR>
 * @author Robson Sanchez/Setpoint Inform�tica Ltda. <BR>
 * criada: 11/12/2006. <BR>
 */


public final class DbConnectionFactory {

   /** Log da classe. **/
   private static final Logger LOGGER = createLogger();

   /** Inst�ncia no formato Singleton. **/
   private static final DbConnectionFactory INSTANCE =
      new DbConnectionFactory();

   /** Construtor da classe. **/
   private DbConnectionFactory() {
      //N�o tem conte�do.
   }

   /**
    
    * Tem como objetivo retornar a inst�ncia da classe.
    * @return Retorna a inst�ncia da classe DbConnectionFactory.
    */
   public static DbConnectionFactory getInstance() {
      return INSTANCE;
   }

   /**
    * Retorna a inst�ncia do Log.
    * @return Retorna um Log4j.
    */
   private Logger getLogger() {
      return LOGGER;
   }

   /**
    * Retorna uma conex�o do concentrador.
    * @param context Contexto http.
    * @param sessionID Sess�o utilizada como chave para o recurso.
    * @return Retorna uma conex�o JPA.
    * @throws SQLException Propaga exce��es JPA.
    */
   public EntityManager  getConnection(final ServletContext context,
         final String sessionID, final String factory) throws SQLException {
      EntityManager manager = null;
      try {
         manager = getConnection(context, sessionID, factory, "", "");
         // conn = dataSource.getConnection();
      } catch (SQLException esql) {
         getLogger().error(esql);
         throw esql;
      }
      return manager;
   }

   /**
    * Libera um recurso para ser reutilizado.
    * @param context Contexto da aplica��o.
    * @param sessionID Sess�o utilizada como chave.
    * @throws ResourceException Propaga exce��o caso n�o possa
    * liberar o recurso.
    */
   public void recycleConnection(final ServletContext context,
         final String sessionID) throws ResourceException {
      ResourceKey resource = null;
      final DbConnectionPool pool = (DbConnectionPool)
         context.getAttribute("db-connection-pool");
      try {
         resource = pool.getResourceSession(sessionID);
         if (resource != null) {
            pool.recycleResource(resource);
         }
      } catch (Exception e) {
         getLogger().error(e);
         throw new ResourceException(e.getMessage());
      }
   }

   /**
    * Fecha a conex�o com banco de dados JDBC.
    * @param context Contexto da aplica��o para buscar o pool de recursos.
    * @param sessionID Sess�o chave para o recurso.
    * @throws ResourceException Propaga a exce��o se n�o for poss�vel
    * fechar a conex�o.
    */
   public void closeConnection(final ServletContext context,
         final String sessionID) throws ResourceException {
      this.closeConnection(context, sessionID, null, null);
   }

   /**
    * Fecha a conex�o com banco de dados JDBC.
    * @param context Contexto da aplica��o para buscar o pool de recursos.
    * @param sessionID Sess�o chave para o recurso.
    * @param useriddb ID do usu�rio conectado.
    * @param passworddb Senha do usu�rio.
    * @throws ResourceException Propaga a exce��o se n�o for poss�vel
    * fechar a conex�o.
    */
   public void closeConnection(final ServletContext context,
         final String sessionID, final String useriddb, final String passworddb)
         throws ResourceException {
      ResourceKey resource = null;
      final DbConnectionPool pool = (DbConnectionPool)
         context.getAttribute("db-connection-pool");
      if (useriddb == null) {
         resource = pool.getResourceSession(sessionID);
      } else {
         resource = pool.getResource(sessionID, useriddb, passworddb);
      }
      if (resource != null) {
         pool.closeResource(resource);
      }
   }

   /**
    * Retorna a conex�o JPA consistindo usu�rio e senha.
    * @param context Contexto do aplicativo para pesquisar o pool.
    * @param sessionID Identifica��o da sess�o chave.
    * @param fact String com o descritor para a conex�o.
    * @param useridcon ID. do usu�rio a consistir.
    * @param passwordcon Senha do usu�rio a consistir.
    * @return Retorna uma refer�ncia para objeto de conex�o JDBC.
    * @throws SQLException Propaga uma exce��o SQL caso n�o encontre um
    * objeto consistente.
    */
   public EntityManager getConnection(
         final ServletContext context, final String sessionID,
         final String fact, final String useridcon,
         final String passwordcon) throws SQLException {
      final DbConnectionPool pool = (DbConnectionPool)
         context.getAttribute("db-connection-pool");
      EntityManager manager = null;
      ResourceKey resource = null;
      resource = pool.getResourceSession(sessionID);
      if (resource == null) {
         try {
            if (useridcon != null && !useridcon.equals("")
                  && passwordcon != null && !passwordcon.equals("")) {
               pool.setUser(useridcon);
               pool.setPassword(passwordcon);
               pool.setSessionID(sessionID);
            }
            resource = pool.getResource(sessionID, useridcon, passwordcon);
            if (resource == null
                  || !resource.getPassword().equals(passwordcon)) {
               recycleConnection(context, sessionID); // Recicla a
               // conex�o e
               // retorna
               // erro
               throw new ResourceException("Senha inv�lida."); // Exce��o
               // de senha
               // inv�lida
            }
            manager = (EntityManager)
               resource.getResource();
         } catch (ResourceException e) {
            getLogger().error(e);
         }
      }
      return manager;
   }

   /**
    * Cria uma inst�ncia do log4j da classe.
    * @return Retorna a inst�ncia do log da classe.
    */
   private static Logger createLogger() {
      return Logger.getLogger("org.freedom.jpa.DbConnectionFactory");
   }

   /**
    * Fecha a conex�o JPA, bem como os recursos SQL.
    * @param manager Recebe como par�metro a conex�o.
    */
   public void closeConnection(final EntityManager manager) {
      if (manager != null) {
         manager.close();
      }
   }

}
