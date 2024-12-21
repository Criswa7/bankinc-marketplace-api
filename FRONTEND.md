# Frontend Documentation - Bank Inc Marketplace

## Estructura del Proyecto

```
src/
├── app/
│   ├── core/                 # Servicios y modelos core
│   │   ├── models/          # Interfaces y tipos
│   │   └── services/        # Servicios compartidos
│   │
│   ├── features/            # Módulos funcionales
│   │   ├── card/           # Gestión de tarjetas
│   │   │   └── components/
│   │   │       ├── card-creation/
│   │   │       ├── card-recharge/
│   │   │       └── card-list/
│   │   │
│   │   └── marketplace/    # Módulo de marketplace
│   │       └── components/
│   │           ├── product-list/
│   │           ├── product-search/
│   │           ├── shopping-cart/
│   │           └── checkout/
│   │
│   └── shared/             # Componentes compartidos
└── environments/           # Configuración por ambiente

```

## Componentes Principales

### Módulo de Tarjetas

#### card-creation
- Formulario de creación de tarjetas
- Validación de campos (nombre, tipo, ID de producto)
- Generación automática de número de tarjeta

```typescript
export interface CardCreationDTO {
    holderName: string;
    cardType: CardType;
    productId: string;
}
```

#### card-recharge
- Recarga de saldo
- Validación de número de tarjeta
- Confirmación de recarga exitosa

#### card-list
- Visualización de transacciones
- Filtrado por número de tarjeta
- Anulación de transacciones

### Módulo de Marketplace

#### product-list
- Carrusel de productos destacados
- Grid de productos
- Búsqueda y filtrado
- Integración con fakestoreapi.com

#### shopping-cart
- Carrito flotante
- Gestión de cantidades
- Cálculo de totales
- Persistencia en memoria

#### checkout
- Formulario de pago
- Validación de tarjeta
- Procesamiento de transacción

## Servicios

### CardService
```typescript
export class CardService {
    createCard(card: CardCreationDTO): Observable<Card>
    rechargeCard(recharge: CardRechargeDTO): Observable<Card>
    getCard(cardNumber: string): Observable<Card>
}
```

### ProductService
```typescript
export class ProductService {
    getProducts(): Observable<Product[]>
    searchProducts(query: string): Observable<Product[]>
}
```

### CartService
```typescript
export class CartService {
    addToCart(product: Product): void
    removeFromCart(productId: number): void
    updateQuantity(productId: number, quantity: number): void
    getCartItems(): Observable<CartItem[]>
    getTotalAmount(): number
}
```

## Estados y Manejo de Datos

### Estado Global
- Carrito de compras: BehaviorSubject en CartService
- Productos: Llamadas HTTP en ProductService
- Tarjetas: Llamadas HTTP en CardService

### Estado Local
- Formularios: Reactive Forms
- UI States: Variables de componente
- Loading States: Banderas booleanas

## Estilos y CSS

### Enfoque de Estilos
- CSS puro (sin frameworks)
- Estilos modulares por componente
- Variables CSS para temas
- Media queries para responsividad

```css
/* Ejemplo de variables CSS */
:root {
    --primary-color: #0066cc;
    --secondary-color: #f8f9fa;
    --error-color: #dc3545;
    --success-color: #28a745;
}
```

## Comunicación con el Backend

### Interceptors
- Manejo de errores HTTP
- Headers de CORS
- Loading states

### Environments
```typescript
export const environment = {
    production: false,
    apiUrl: 'http://localhost:8080'
};
```

## Testing

### Unit Tests
- Servicios: Pruebas de lógica de negocio
- Componentes: Pruebas de renderizado y comportamiento
- Pipes: Pruebas de transformación

```typescript
describe('CartService', () => {
    it('should calculate total correctly', () => {
        // Test implementation
    });
});
```

## Patrones Implementados

### Patrón Observer
- Uso de RxJS para estado reactivo
- Subscripciones a cambios del carrito
- Actualizaciones de UI en tiempo real

### Patrón Singleton
- Servicios providedIn: 'root'
- Estado compartido del carrito
- Configuración global

### Patrón Command
- Acciones del carrito
- Manejo de transacciones
- Operaciones de tarjetas

## Guías de Rendimiento

### Optimizaciones
- Lazy loading de módulos
- Standalone components
- OnPush change detection
- Unsubscribe de observables

### Best Practices
- Componentes pequeños y reutilizables
- Servicios para lógica de negocio
- Tipado estricto con TypeScript
- Manejo de errores consistente

## Debugging

### Chrome DevTools
- Network tab para requests
- Elements para inspección DOM
- Sources para debugging

### Angular DevTools
- Component tree
- Profiler
- Router tree

## Despliegue

### Producción Build
```bash
ng build --configuration production
```

### Configuración Nginx
```nginx
server {
    listen 80;
    server_name marketplace.bankinc.com;
    root /usr/share/nginx/html;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }
}
```

## Mantenimiento

### Actualizaciones
- Angular CLI updates
- Dependencias npm
- Versiones de API

### Monitoreo
- Error tracking
- Performance metrics
- User analytics