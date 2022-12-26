import React, { useState, useEffect } from "react";
import axios from "axios";
import styled from "styled-components";

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
      <Mainbar>
        <Dflex>
          <h1>All Questions</h1>
          <button>Ask Question</button>
        </Dflex>
        <Dflex>
          <div>7,143,884 questions with no upvoted or accepted answers</div>
          <div>
            <button>Newest</button>
            <button>Active</button>
            <button>Bountied</button>
            <button>Unanswered</button>
            <button>More</button>
            <button>Filter</button>
          </div>
        </Dflex>
        <Questions>
          {question.map((ele) => (
            <Summary>
              <Stats>
                <Items> {ele.votes} votes</Items>
                <Items> {ele.answers} answers</Items>
                <Items> {ele.views} views</Items>
              </Stats>
              <Content>
                <h3> {ele.title} </h3>
                <div>
                  {" "}
                  {ele.userID} {ele.reputation} modified {ele.modified}{" "}
                </div>
              </Content>
            </Summary>
          ))}
        </Questions>
      </Mainbar>
      <div>Right Sidebar</div>
    </>
  );
}
