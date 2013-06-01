/*
 * RHQ Management Platform
 * Copyright (C) 2005-2013 Red Hat, Inc.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package cz.mzk.editor.irc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Properties;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.pircbotx.PircBotX;

/**
 * @author Jirka Kremser
 *
 */
public class MeditorIrcBot extends PircBotX {
    
    private static final String TRUSTSTORE_NAME = "cacerts.jks";
    
    public MeditorIrcBot(MeditorIrcBotListener bot) {
        setName("meditor-bot");
        setVersion("1.1");
        setFinger("MEdit IRC bot (source code in meditor git repo under resources/meditor-ircBot/). You may want to start with !help command.");

        setVerbose(true);
        setAutoNickChange(true);

        getListenerManager().addListener(bot);
        setSocketTimeout(1 * 60 * 1000); // 1 minute
    }
    
    public static void main(String[] args) throws Exception {
        if (args.length != 2 && args.length != 3) {
            System.err.println("Usage: MeditorIrcBot IRC_SERVER IRC_CHANNEL [meditor-ircBot.properties]");
            System.err.println(" e.g.: MeditorIrcBot irc.freenode.net '#meditor'");
            System.exit(1);
        }
        String server = args[0];
        String channel = args[1];
        if (channel.charAt(0) != '#') {
            channel = '#' + channel;
        }

        MeditorIrcBotListener botListener = new MeditorIrcBotListener(server, channel);
        if (args.length == 3) {
            File propertyFile = new File(args[2]);
            if (!propertyFile.exists()) {
                System.err.println("Provided property file [" + args[2] +  "] does not exist");
                System.exit(2);
            }
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(propertyFile);
            properties.load(fis);
            String docspaceLogin = properties.getProperty("docspace_login");
            String docspacePassword = properties.getProperty("docspace_password");
            if (docspaceLogin == null || docspaceLogin.isEmpty() || docspacePassword == null || docspacePassword.isEmpty()) {
                System.err.println("The property format has bad format");
                System.err.println("It must contain following key-value pairs\n");
                System.err.println("docspace_login=X");
                System.err.println("docspace_password=Y");
                System.exit(3);
            }
            fis.close();
            
            setupTrustStore();
            
            botListener.setDocspaceLogin(docspaceLogin);
            botListener.setDocspacePassword(docspacePassword);
        }

        PircBotX bot = new MeditorIrcBot(botListener);
        bot.connect(server);
        bot.joinChannel(channel);
    }
    
    private static void setupTrustStore() {
        TrustManagerFactory trustManagerFactory;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keystore;
            keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream keystoreStream = MeditorIrcBot.class.getResourceAsStream(TRUSTSTORE_NAME);
            keystore.load(keystoreStream, "rhqirc".toCharArray());
            trustManagerFactory.init(keystore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            SSLContext ctx = SSLContext.getInstance("SSL");
            ctx.init(null, trustManagers, null);

            SSLContext.setDefault(ctx);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
