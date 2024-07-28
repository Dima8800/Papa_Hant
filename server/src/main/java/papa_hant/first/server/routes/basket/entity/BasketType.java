package papa_hant.first.server.routes.basket.entity;

public enum BasketType {
    PAID, // Оплачена
    PAYMENT_PENDING, // Ожидает оплаты
    CHECKOUT, // Просто корзина
    ORDER_BEING_PROCESSED // Заказ в процессе обработки
}
