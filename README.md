# Spring Boot Microservices Project (User + Notification Services)

## What is this Project?

This project is a simple demonstration of **how microservices work** using Spring Boot. It shows how two independent services can **talk to each other** and how we can deploy them using **Docker** on the cloud (AWS EC2). We also use **Nginx** to securely expose only one of them to the outside world.

---

## What are the Two Microservices?

### 1.user-service
- A Spring Boot app connected to a MySQL database.
- Stores users (name, email) and provides REST APIs:
  - `GET /users`
  - `POST /users`, etc.
- This is a **backend data service**.

### 2.notification-service
- A separate Spring Boot app.
- Calls the user-service using REST to get all users.
- Provides endpoint:
  - `GET /notifications/notify-users`
- It simulates "notifying" all users by returning a message like:
  > "Notified 5 users."

---

## Why Microservices?

Because:
- Services are small and focused.
- You can **scale**, **deploy**, and **manage** each one separately.
- They can communicate over the network using REST APIs.

---

## How They Talk to Each Other

We use Spring's `RestTemplate` inside notification-service:

```java
List<Map<String, Object>> users = restTemplate.getForObject("http://user-service:8080/users", List.class);
```

Inside Docker, services can use each other's names as hostnames.

---

## Docker + Docker Compose

We wrap each service in its own **Docker container**.

Then use **Docker Compose** to:
- Run MySQL
- Start both services
- Connect them into a shared **network**

You can start everything with:

```bash
docker compose up --build
```

---

## Deployment on AWS EC2

We use a virtual server (EC2) to run everything in the cloud:

1. Create an EC2 instance (Amazon Linux 2)
2. Install Docker and Docker Compose
3. Copy project files using `scp`
4. Run everything using Docker Compose

Your apps are now live on:
- `http://<EC2_IP>:8081/users` → user-service
- `http://<EC2_IP>:8082/notifications/notify-users` → notification-service

---

## Nginx + Basic Auth

We use **Nginx** as a reverse proxy. It does two things:
1. Hides the user-service from the public
2. Exposes only `/notify-users` endpoint with a **username + password** prompt

So only authorized people can call it:
```bash
curl -u myuser:mypassword http://<EC2_IP>/notify-users
```

---

## Why This Is Valuable

✅ Learn how **microservices communicate**

✅ Practice real-world **Docker + Spring Boot**

✅ Gain confidence in **cloud deployment**

✅ Understand how to use **Nginx for API Gateway**

---

## Key Concepts Covered

| Concept                     | What You Learned                                            |
|----------------------------|-------------------------------------------------------------|
| Microservices              | How to break apps into independent services                |
| REST Communication         | Using `RestTemplate` to talk between services              |
| Docker                     | Containerizing Java apps                                   |
| Docker Compose             | Orchestrating multi-container apps                         |
| MySQL in Docker            | Using database containers                                  |
| EC2 Deployment             | Running apps in the cloud                                  |
| Nginx + Basic Auth         | Secure API Gateway via password protection                 |

---

## Summary

This is a complete beginner-to-intermediate project to understand:
- Microservice design
- Container orchestration
- Cloud deployment
- Secure API exposure

A perfect **end-to-end hands-on** microservices project.
