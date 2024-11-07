# The Homeric Odyssey - Registry Module

The Registry module is a core component of The Homeric Odyssey system, responsible for maintaining all the primary entities and their relationships.

## Overview

The Registry module serves as the central hub for managing the following types of data:

1. **User Registry**
    - Stores customer and vendor user profiles
    - Handles user authentication and authorization
    - Integrates with the Keycloak identity provider

2. **Vendor Registry**
    - Maintains information about registered vendors
    - Tracks vendor-specific configurations and settings
    - Provides vendor management capabilities

3. **Product Registry**
    - Catalogs all products available in the system
    - Links products to their respective vendors
    - Stores product details, inventory, and pricing

4. **Order Registry**
    - Records all customer orders placed in the system
    - Tracks order status and history
    - Provides order management functionalities

The Registry module acts as the single source of truth for all these critical entities, ensuring data integrity and consistency across the entire Homeric Odyssey platform.

## Key Features

1. **User Management**
    - Onboard new customers and vendors
    - Maintain user profiles and contact information
    - Manage user roles and permissions

1. **Vendor Administration**
    - Register new vendors in the system
    - Configure vendor-specific settings and preferences
    - Provide vendor-level access control

1. **Integration with Other Modules**
    - Integrate with the Product Core module for product data
    - Collaborate with the Order Core module for order management
    - Share user information with the Authentication layer

## Architecture

The Registry module is designed as a standalone microservice within the Homeric Odyssey system. It utilizes the following key technologies:

- **Database**: PostgreSQL with JPA-Hibernate for data persistence
- **Security**: Keycloak for user authentication and authorization

The module exposes a set of RESTful APIs that allow other components to interact with the registry data. It also subscribes to relevant events from the Product Core and Order Core modules to keep the registry data up-to-date in real-time.

## Getting Started

To get started with the Registry module, please follow these steps:

1. **Set up the Development Environment**
    - Ensure you have the required dependencies installed (PostgreSQL, Keycloak, RabbitMQ, Redis)
    - Clone the Homeric Odyssey repository from the central repo
    - Navigate to the `registry` directory and review the README for setup instructions

2. **Run the Registry Service**
    - Start the Registry service using the provided commands
    - Verify that the service is running and accessible

3. **Explore the Registry APIs**
    - Review the API documentation for available endpoints
    - Use a tool like Postman to test the Registry APIs

4. **Integrate with Other Modules**
    - Familiarize yourself with the event-driven communication patterns
    - Implement integrations with the Product Core and Order Core modules

For more detailed information, please refer to the Homeric Odyssey project documentation or reach out to the development team.