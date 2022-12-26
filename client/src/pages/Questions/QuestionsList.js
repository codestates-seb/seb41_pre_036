import React, { useState, useEffect } from "react";
import axios from "axios";
import styled from "styled-components";
import Footer from "../../components/Footer";
import LayoutContainer from "../../components/LayoutContainer";
import PageContainer from "../../components/PageContainer";
import Sidebar from "../../components/Sidebar";
import Header from "../../components/Header";

const Mainbar = styled.div`
  border-left: 1px solid hsl(210, 8%, 85%);
  max-width: 728px;
`;

const Dflex = styled.div`
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid;
`;

const Questions = styled.div``;

const Summary = styled.div`
  display: flex;
`;

const Stats = styled.div``;

const Content = styled.div``;

const Items = styled.div`
  margin-right: 10px;
`;

export default function QuestionsList() {
  const [question, setQuestion] = useState([]);

  // json-server를 키려면 cli에 json-server --watch data.json --port 3001
  const data = async () => {
    try {
      const list = await (
        await axios.get("http://localhost:3001/questions")
      ).data;
      setQuestion(list);
    } catch (e) {
      console.error(e);
    }
  };

  useEffect(() => {
    data();
  }, []);

  return (
    <>
     <Header />
      <Sidebar />
      <LayoutContainer>
        <PageContainer>
        </PageContainer>
      </LayoutContainer>
      <Footer />
    </>
  );
}
