# Oldface
Social Network for old people made with Java &amp; Tomcat for the Software Engineering University class. 
Group project made by myself, Hannes Kramml, Stefan Berg and Valentin Haag.

We had to:
* Use Tomcat and Servlets
* Use Java Serialize for storing everything (nevermind thread-safety)
* Implement a bunch of fixed use cases
* Use Jsps
* HttpSessions

What instead/additionally I forced unto my team:
* Jtwig
* Maven
* We also decided together to use Model-View-Controller, or an adaption thereof

What I wish we had used but had no time for:
* Some dependency injection container
* A real database
* JavaScript for frontend stuff (Not having to handle everything with a servlet would be nice)

The workload was split the following way:
* **Myself:** Controllers, Basic Setup of the Project, Maven Setup, Twig Setup and all the basic twig files (navbar, base.twig, etc.), some frontend-design
* **Hannes:** All the Serialize stuff + the Logic + Statistics
* **Stefan & Valentin:** Model, Frontend

What I learned:
* GET Requests should not change anything in the backend. If a change should happen, use POST.
* Team work is hard, you really gotta split the tasks well. Completely splitting frontend and controller (Servlets) code does not really work
* HttpSessions are quite easy
* I like our own adaption of MVC we did, which had an additional Logic and DAO component.
* JSPs are really ugly, glad we did not work with that
* Maven makes built a lot easier

