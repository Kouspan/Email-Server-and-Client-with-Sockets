# Email-Server-and-Client-with-Sockets

A Java project made for the course "Communication Networks" to showcase how apps communicate at the higher level.
It consists of 3 modules, one for the server, one for the client and a module for the shared classes. The server and
client communicate by sending requests and responses with java.net.Socket and java.net.ServerSocket. It works locally
using TCP ports but can be expanded to work remotely.

### Server 
- The server has a simple GUI where it is logging its current state and client servicing.
- It can service simultaneously multiple clients.
- Users can login to a pre-existing account or register a new one.   
- All pre-existing information about user accounts and their inboxes is hardcoded to Server.java file. 
- The server does not keep a database of users and inboxes, so everything gets deleted when the server is shut down.

### Client
The client has a Java Swing GUI where the user can see their inbox, fetch and read emails, write and send them to other users. 

A more detailed report about the code is available here [Communication_Networks_Socket_Project.pdf](https://github.com/Kouspan/Email-Server-and-Client-with-Sockets/files/8899390/Communication_Networks_Socket_Project.pdf) (in greek).
