# StreamVerse Platform

**StreamVerse** is a high-performance, distributed video streaming backend engineered using a microservices architecture. Designed for scalability and resilience, this platform manages the complete lifecycle of digital media content—from upload and transcoding to secure streaming and subscription management.

The system features a robust payment integration with Stripe, automating complex subscription logic including nightly renewal checks, cancellations, and status synchronization.

## 🚀 Key Features

* **Microservices Architecture:** Fully decoupled services (User, Content, Media, Subscription, Payment) communicating via REST (Feign) and Event Streams.
* **Media Processing Pipeline:** Asynchronous video transcoding and chunking using **FFmpeg** and **JavaCV**, optimized for adaptive streaming.
* **Hybrid Storage Strategy:** Utilizes **MinIO** (S3 compatible) for object storage and a mix of **PostgreSQL** & **MongoDB** for structured and semi-structured metadata.
* **Automated Billing:** Integrated **Stripe** gateway with **Quartz Scheduler** for precise, automated recurring billing and subscription expiration handling.
* **Event-Driven Communication:** Uses **Apache Kafka** and **Zookeeper** to handle high-throughput inter-service messaging and notifications.
* **Security First:** Stateless authentication utilizing **JWT (JSON Web Tokens)** and Spring Security.

## 🛠️ Technology Stack

This project leverages a modern, cloud-native stack running on **Java 22**.

### Core Frameworks
* **Spring Boot:** Rapid application development and dependency injection.
* **Spring Cloud:**
    * **Gateway:** API routing, throttling, and load balancing.
    * **Eureka:** Service discovery and registration.
    * **Config Server:** Centralized configuration management.
    * **OpenFeign:** Declarative REST clients.

### Data & Storage
* **PostgreSQL:** Primary relational database for user and transactional data.
* **MongoDB:** NoSQL storage for content metadata and unstructured logs.
* **Redis:** In-memory caching for high-speed data retrieval.
* **MinIO:** Self-hosted object storage for video and image assets.
* **Flyway:** Database schema migration and version control.

### Messaging & Async
* **Apache Kafka:** Distributed event streaming platform.
* **Zookeeper:** Coordination service for distributed applications.
* **Quartz Scheduler:** Job scheduling for background tasks (subscriptions, cleanup).

### Media & Third-Party
* **FFmpeg / JavaCV:** Multimedia handling and video compression.
* **Stripe API:** Payment processing infrastructure.

## 🏗️ Architecture Diagrams

For a deeper dive into the system design, please refer to the `diagrams/` directory. This folder contains UML and architectural visualizations detailing:
* Video Upload & Transcoding Sequence
* Subscription & Payment Flows
* Database Entity Relationships (ERD)
* Service Interaction Maps

