import { createBrowserRouter, RouterProvider } from "react-router-dom";
import styled from "styled-components";
import NotFound from "./pages/NotFound";
import QuestionDetail from "./pages/Questions/QuestionDetail";
import QuestionsList from "./pages/Questions/QuestionsList";
import Login from "./pages/Register/Login";
import Signup from "./pages/Register/Signup";
import Logout from "./pages/Register/Logout";
import Tags from "./pages/Tags";
import Users from "./pages/Users";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";
import Footer from "./components/Footer";

const Homepage = styled.div`
  max-width: 1264px;
  width: 100%;
  background: none;
  display: flex;
  justify-content: space-between;
  margin: 0 auto;
`;

const router = createBrowserRouter([
  {
    path: "/",
    element: <QuestionsList />,
    errorElement: <NotFound />,
    children: [],
  },
  {
    path: "/:questionId",
    element: <QuestionDetail />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/signup",
    element: <Signup />,
  },
  {
    path: "/logout",
    element: <Logout />,
  },
  {
    path: "/tags",
    element: <Tags />,
  },
  {
    path: "/users",
    element: <Users />,
  },
]);

function App() {
  return (
    <>
      <Header />
      <Homepage>
        <Sidebar />
        <RouterProvider router={router} />
      </Homepage>
      <Footer />
    </>
  );
}

export default App;
