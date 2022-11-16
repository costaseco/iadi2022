import { Header, Footer, Container } from './components/layout'
import { Navigation, Login } from './components/util';
import Books from './components/Books';

function App() {
  return (
    <div className="App">
      <Header title={"My Bookshelf"}>
        <Navigation menuItems={["All Books", "Advanced Search", "Profile"]} />
        <Login user={"joao"} />
      </Header>
      <Container>
        <Books/>
      </Container>
      <Footer/>
    </div>
  );
}

export default App;
