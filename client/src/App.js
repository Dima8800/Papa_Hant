import React from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Items from "./components/Items"
import Categories from "./components/Categories";

class App extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      orders: [],
      items: [
        {
          id: 1,
          title: 'Кошелек c одним карманом',
          img: 'first-kosh.jpg',
          desc: 'Натуральная кожа1',
          category: 'kosh',
          price: '5000'
        },
        {
          id: 2,
          title: 'Кошелек с двумя карманами',
          img: 'second-kosh.jpg',
          desc: 'Натуральная кожа2',
          category: 'kosh',
          price: '6000'
        },
        {
          id: 3,
          title: 'сумка для мужчины',
          img: 'first-symka.jpg',
          desc: 'Натуральная кожа3',
          category: 'symka',
          price: '5000'
        },
        {
          id: 4,
          title: 'сумка для ;tyoby',
          img: 'first-symka.jpg',
          desc: 'Натуральная кожа3',
          category: 'сумка',
          price: '5000'
        }
      ]
    }
    this.addToOrder = this.addToOrder.bind(this)
    this.deleteOrder = this.deleteOrder.bind(this)
  }

  render() {
    return (
      <div className="wrapper">
        <Header orders={this.state.orders} onDelete={this.deleteOrder} />
        <Categories />
        <Items items = {this.state.items} onAdd={this.addToOrder} />
        <Footer/>
      </div>
    )
  }

  deleteOrder(id){
    this.setState({orders: this.state.orders.filter(el => el.id !== id)})
  }

  addToOrder(item){
    this.setState({orders: [...this.state.orders, item]}, () => {
      console.log(this.state.orders)
    })
  }
}

export default App;
