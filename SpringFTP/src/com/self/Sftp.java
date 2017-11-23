package com.self;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

/**
 * @author https://kodehelp.com
 *
 */
public class Sftp {

		static ChannelSftp channelSftp = null;
		static Session session = null;
		static Channel channel = null;
		static String PATHSEPARATOR = "/";

		final static String SFTPHOST ="52.66.153.105";
		final static String SFTPPORT = "22";
		final static String SFTPUSER = 	"sftp_user";
		final static String SFTPPASS ="sftp_user1086#";
		final static String SFTPWORKINGDIR ="/Omniware/inbound";
		       
		final static String LOCALDIRECTORY = "E:/mandee/mandee6.4/hybris/data/acceleratorservices/export";
		

		public static void useFtpUtil(final String path) {

				
				try {
						final JSch jsch = new JSch();
						session = jsch.getSession(SFTPUSER, SFTPHOST,
						        Integer.parseInt(SFTPPORT));
						session.setPassword(SFTPPASS);
						final java.util.Properties config = new java.util.Properties();
						config.put("StrictHostKeyChecking", "no");
						session.setConfig(config);
						session.connect();
						
						channel = session.openChannel("sftp");
						channel.connect();
					
						channelSftp = (ChannelSftp) channel;
						/*channelSftp.cd(SFTPWORKINGDIR);
						File f = new File("E:/Workspace/Test_Doc.txt");
						channelSftp.put(new FileInputStream(f), f.getName());
					 System.out.println("File transfered successfully to host.");*/
					 
					 
					 
					/* channelSftp.cd(SFTPWORKINGDIR);
						File file = new File("E:");
						FileOutputStream fileOutputStream = new FileOutputStream(file);
						channelSftp.get("/", fileOutputStream);*/
					 
						System.out.println("File Download successfully to Local.");
						 
					 
					 
						//recursiveFolderDownload("/Omniware/outbound", "E:\\");
						//recursiveFolderUpload(LOCALDIRECTORY + path ,
						    //    SFTPWORKINGDIR);
				} catch (final Exception ex) {
System.out.println(ex);
						
				} finally {

						channelSftp.exit();
						
						channel.disconnect();
						
						session.disconnect();
				}
		}

		/**
		 * This method is called recursively to Upload the local folder content to
		 * SFTP server
		 *
		 * @param sourcePath
		 * @param destinationPath
		 * @throws SftpException
		 * @throws FileNotFoundException
		 */
		private static void recursiveFolderUpload(final String sourcePath,
		        final String destinationPath)
		        throws SftpException, FileNotFoundException {

				final File sourceFile = new File(sourcePath);
				if (sourceFile.isFile()) {

						// copy if it is a file
						channelSftp.cd(destinationPath);
						if (!sourceFile.getName().startsWith(".")) {
								channelSftp.put(new FileInputStream(sourceFile),
								        sourceFile.getName(), ChannelSftp.OVERWRITE);
						}

				} else {

						
						final File[] files = sourceFile.listFiles();

						if (files != null && !sourceFile.getName().startsWith(".")) {

								channelSftp.cd(destinationPath);
								SftpATTRS attrs = null;

								// check if the directory is already existing
								try {
										attrs = channelSftp
										        .stat(destinationPath + "/" + sourceFile.getName());
								} catch (final Exception e) {
										
								}

								// else create a directory
								if (attrs != null) {
										
								} else {
										
										channelSftp.mkdir(sourceFile.getName());
								}

								for (final File f : files) {
										recursiveFolderUpload(f.getAbsolutePath(),
										        destinationPath + "/" + sourceFile.getName());
								}

						}
				}

		}

		public void download(final String directory, final String downloadFile,
		        final String saveFile, final ChannelSftp sftp) {
				try {
						sftp.cd(directory);
						File file = new File(saveFile);
						FileOutputStream fileOutputStream = new FileOutputStream(file);
						sftp.get(downloadFile, fileOutputStream);
						fileOutputStream.close();
						fileOutputStream = null;
						file = null;
				} catch (final Exception e) {
						e.printStackTrace();
				}
		}
		
		

}
